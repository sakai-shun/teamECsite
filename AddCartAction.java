package com.internousdev.texas.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.texas.dao.CartInfoDAO;
import com.internousdev.texas.dao.ProductInfoDAO;
import com.internousdev.texas.dto.CartInfoDTO;
import com.internousdev.texas.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware{

	private int productId;
	private int productCount;
	private int totalPrice;
	private List<CartInfoDTO> cartInfoList;
	private Map<String,Object> session;

	public String execute(){
//		セッションタイムアウト(仮ユーザーIDとユーザーIDがセッションに入っていない場合)
		if(!session.containsKey("tempUserId") && !session.containsKey("userId")){
			return "sessionTimeout";
		}
		

		String result=ERROR;
		String userId=null;
		if(productCount < 1 || productCount > 5){
			return ERROR;
		}
//		ログインしている場合はuserIdにユーザーIDを代入。していない場合はuserIdに仮ユーザーIDを代入。
		int logined=Integer.parseInt(String.valueOf(session.get("logined")));
		if(logined==1){
			userId=String.valueOf(session.get("userId"));
		}else{
			userId=String.valueOf(session.get("tempUserId"));
		}
//		商品情報を取得する。後で引数に値段を入れたいから。
		ProductInfoDAO productInfodao=new ProductInfoDAO();
		ProductInfoDTO productInfodto=productInfodao.getProductInfo(productId);

		CartInfoDAO cartInfoDAO=new CartInfoDAO();
		int count=0;
//		同じ商品のカート情報があるかないかで場合分けする。
		if(cartInfoDAO.isExistsCartInfo(userId,productId)){
//		カート情報がある場合は個数を上書きする
			count=cartInfoDAO.updateProductCount(userId,productId,productCount);
//		ない場合は、カートに新しく情報を追加する
		}else{
			count=cartInfoDAO.setCartInfo(userId,productId,productCount,productInfodto.getPrice());
		}
//		カート画面に商品の情報を表示させる
		if(count>0){
			cartInfoList=cartInfoDAO.getCartInfoList(userId);
			totalPrice=cartInfoDAO.getTotalPrice(userId);
			return SUCCESS;
		}
		return result;
	}
	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId=productId;
	}
	public int getProductCount(){
		return productCount;
	}
	public void setProductCount(int productCount){
		this.productCount=productCount;
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
	public void setCartInfoList(List<CartInfoDTO> cartInfoList){
		this.cartInfoList=cartInfoList;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}
