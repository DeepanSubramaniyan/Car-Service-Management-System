package com.carservice.model;

public class User {
	protected int id;
	protected String name;
	protected String vehicleNumber;
	protected String vehicleModel;
	protected String phone;
	protected String date;
	protected String pickUpDate;
	protected String serviceType;
	
	public User() {
	}
	
	public User(String name, String vehicleNumber, String vehicleModel,String phone,String date,String pickUpDate,String serviceType) {
//		super();
		this.name = name;
		this.vehicleNumber = vehicleNumber;
		this.vehicleModel = vehicleNumber;
		this.phone=phone;
		this.date=date;
		this.pickUpDate=pickUpDate;
		this.serviceType=serviceType;
	}

	public User(int id, String name, String vehicleNumber, String vehicleModel,String phone,String date,String pickUpDate,String serviceType) {
//		super();
		this.id = id;
		this.name = name;
		this.vehicleNumber = vehicleNumber;
		this.vehicleModel = vehicleNumber;
		this.phone=phone;
		this.date=date;
		this.pickUpDate=pickUpDate;
		this.serviceType=serviceType;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	
	
}


