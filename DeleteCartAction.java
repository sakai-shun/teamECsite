package com.internousdev.texas.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.texas.dao.CartInfoDAO;
import com.internousdev.texas.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCartAction extends ActionSupport implements SessionAware{

	private int totalPrice;
	private List<CartInfoDTO> cartInfoList;
	private Map<String,Object>session;
	private String[] checkList;

	public String execute(){
//		セッションタイムアウト
		if(!session.containsKey("tempUserId") && !session.containsKey("userId")){
			return "sessionTimeout";
		}
		String result=ERROR;
		CartInfoDAO cartInfoDAO=new CartInfoDAO();
		int count=0;
		String userId=null;
		int logined=Integer.parseInt(session.get("logined").toString());
//		ログインしているかしていないかでuserIdにユーザーIDか仮ユーザーIDを代入する
		if(logined==1){
			userId=session.get("userId").toString();
		}else{
			userId=String.valueOf(session.get("tempUserId"));
		}
//		カート画面でチェックを付けた数だけカート情報を削除する
		for(String productId:checkList){
			count+=cartInfoDAO.delete(userId, productId);
		}
//		選択して削除できたらカート画面にカートの情報を表示させる
		if(count==checkList.length){
			cartInfoList=cartInfoDAO.getCartInfoList(userId);
			totalPrice=cartInfoDAO.getTotalPrice(userId);
			result=SUCCESS;
		}
		return result;
	}

	public int getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice){
		this.totalPrice=totalPrice;
	}
	public List<CartInfoDTO> getCartInfoList(){
		return cartInfoList;
	}
	public void setCartInfoList(List<CartInfoDTO>cartInfoList){
		this.cartInfoList=cartInfoList;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public String[] getCheckList(){
		return checkList;
	}
	public void setCheckList(String[] checkList){
		this.checkList=checkList;
	}
}
