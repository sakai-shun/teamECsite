package com.internousdev.texas.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.texas.dao.CartInfoDAO;
import com.internousdev.texas.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{
	private int totalPrice;
	private List <CartInfoDTO> cartInfoList;
	private Map<String,Object> session;

	public String execute() throws SQLException{
		if(!session.containsKey("tempUserId") && !session.containsKey("userId")){
			return "sessionTimeout";
		}

		String userId=null;
		CartInfoDAO cartInfoDAO=new CartInfoDAO();

		int logined=Integer.parseInt(String.valueOf(session.get("logined")));
//		ログインしているかしていないかでuserIdにそれぞれユーザーIDと仮ユーザーIDを代入する。
		if(logined==1){
			userId=session.get("userId").toString();
		}else{
			userId=String.valueOf(session.get("tempUserId"));
		}
//		カート画面に商品情報を表示させる
		cartInfoList=cartInfoDAO.getCartInfoList(userId);
		totalPrice=cartInfoDAO.getTotalPrice(userId);

		return SUCCESS;
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
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
