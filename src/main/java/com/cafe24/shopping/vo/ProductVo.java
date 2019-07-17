package com.cafe24.shopping.vo;

public class ProductVo {

	private long productNo; //상품번호
	private String productName; //상품이름
	private long price; //가격
	private String productDate; // 상품등록일
	private String productEtc; // 상품 기타설명
	private long categoryNo; //카테고리 번호
	private String categoryName; // 카테고리 이름
	private String size; //사이즈
	private String color; // 색깔
	private int quantity; // 수량
	private long imgNo; // 이미지 번호
	private String path; // 이미지 경로
	private int sortNo; // 이미지 정렬순서
	private String imgEtc; // 이미지 기타설명
	
	private String productSort; //상품정렬
	private long stockNo; //재고 번호
	
	
	public long getStockNo() {
		return stockNo;
	}
	public void setStockNo(long stockNo) {
		this.stockNo = stockNo;
	}
	public String getProductSort() {
		return productSort;
	}
	public void setProductSort(String productSort) {
		this.productSort = productSort;
	}
	public long getProductNo() {
		return productNo;
	}
	public void setProductNo(long productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	public String getProductEtc() {
		return productEtc;
	}
	public void setProductEtc(String productEtc) {
		this.productEtc = productEtc;
	}
	public long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getImgNo() {
		return imgNo;
	}
	public void setImgNo(long imgNo) {
		this.imgNo = imgNo;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getSortNo() {
		return sortNo;
	}
	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}
	public String getImgEtc() {
		return imgEtc;
	}
	public void setImgEtc(String imgEtc) {
		this.imgEtc = imgEtc;
	}

	
	
	
}
