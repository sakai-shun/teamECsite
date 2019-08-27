package com.internousdev.texas.dto;
import java.util.Date;
public class CartInfoDTO {

	private int id;
	private String userId;
	private int productId;
	private int productCount;
	private int subTotalPrice;

	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;
	private Date releaseDate;
	private String releaseCompany;

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
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
	public int getSubTotalPrice(){
		return subTotalPrice;
	}
	public void setSubTotalPrice(int subTotalPrice){
		this.subTotalPrice=subTotalPrice;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName=productName;
	}
	public String getProductNameKana() {
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana) {
		this.productNameKana=productNameKana;
	}
	public String getImageFilePath() {
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath=imageFilePath;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName=imageFileName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate=releaseDate;
	}
	public String getReleaseCompany() {
		return releaseCompany;
	}
	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany=releaseCompany;
	}

}
