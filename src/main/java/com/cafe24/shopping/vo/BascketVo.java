package com.cafe24.shopping.vo;

public class BascketVo {
	private long bascketNo;// 장바구니번호
	private long memberNo;// 유저번호
	private long productNo; // 상품번호
	private long stockNo; // 재고번호
	private String color; // 색갈
	private String size; // 사이즈
	private int quantity; //수량
	private long price; //가격
	private String enrollmentDate; //등록날자
	private String ip; // 아이피
	private int existence = 0; // 장바구니에 같은 제품이 있는지 유무
	
	
	public int getExistence() {
		return existence;
	}
	public void setExistence(int existence) {
		this.existence = existence;
	}
	public long getBascketNo() {
		return bascketNo;
	}
	public void setBascketNo(long bascketNo) {
		this.bascketNo = bascketNo;
	}
	public long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(long memberNo) {
		this.memberNo = memberNo;
	}
	public long getProductNo() {
		return productNo;
	}
	public void setProductNo(long productNo) {
		this.productNo = productNo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(String enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getStockNo() {
		return stockNo;
	}
	public void setStockNo(long stockNo) {
		this.stockNo = stockNo;
	}
}
