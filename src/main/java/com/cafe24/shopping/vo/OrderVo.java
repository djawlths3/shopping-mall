package com.cafe24.shopping.vo;

import java.util.List;

public class OrderVo {
	private String orderNo;// 주문번호
	private String id; // 아이디
	private String password;// 비밀번호
	private String name; // 이름
	private String phone; // 폰번호
	private String address;// 배송지
	private String addressDetail; // 배송지 상세
	private String status; // 상태
	private String orderDate; // 주문일
	private String msg;// 요청메세지
	private String completeDate; // 완료일
	
	private String deliveryNo; // 송장번호
	private long bascketNo; // 장바구니 번호
	private int stockNo; // 상품번호
	private int quantity; // 수량
	private String productName; // 상품이름
	private String size; // 사이즈
	private String color; // 색상
	private int price; // 가격
	private int productNo; // 상품번호
	private List bascketProduct; //장바구니
	private int existence; //쿼리에서 재고 있는지 검사
	
	private int paymentNo; //결제 번호
	private String paymentComplete = "N"; //결제유무
	private String paymentMethod = "무통장입금";// 결제 방법
	
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getBascketNo() {
		return bascketNo;
	}
	public void setBascketNo(int bascketNo) {
		this.bascketNo = bascketNo;
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public String getPaymentComplete() {
		return paymentComplete;
	}
	public void setPaymentComplete(String paymentComplete) {
		this.paymentComplete = paymentComplete;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public List getBascketProduct() {
		return bascketProduct;
	}
	public void setBascketProduct(List bascketProduct) {
		this.bascketProduct = bascketProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int i) {
		this.quantity = i;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int product_no) {
		this.productNo = product_no;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	public String getDeliveryNo() {
		return deliveryNo;
	}
	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	public int getStockNo() {
		return stockNo;
	}
	public void setStockNo(int stockNo) {
		this.stockNo = stockNo;
	}
	public int getExistence() {
		return existence;
	}
	public void setExistence(int existence) {
		this.existence = existence;
	}
	
}
