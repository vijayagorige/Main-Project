package com.medicine.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class MedicineRecords {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String companyName;
	private String medicineName;
	private String dosage;
	private String expiryDate;
	private double price;
	private int stock;
	private String uses;
	
	public MedicineRecords() {
	}
	public MedicineRecords(String companyName, String medicineName, String dosage, String expiryDate, double price,
			int stock, String uses) {
		this.companyName = companyName;
		this.medicineName = medicineName;
		this.dosage = dosage;
		this.expiryDate = expiryDate;
		this.price = price;
		this.stock = stock;
		this.uses = uses;
	}
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
		}
		public String getDosage() {
			return dosage;
		}
		public void setDosage(String dosage) {
			this.dosage = dosage;
		}
		public String getExpiryDate() {
			return expiryDate;
		}
		public void setExpiryDate(String expiryDate) {
			this.expiryDate = expiryDate;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public String getUses() {
			return uses;
		}
		public void setUses(String uses) {
			this.uses = uses;
		}
		@Override
		public String toString() {
			return "MedicineRecords [id=" + id + ", companyName=" + companyName + ", medicineName=" + medicineName
					+ ", dosage=" + dosage + ", ExpiryDate=" + expiryDate + ", price=" + price + ", stock=" + stock
					+ ", uses=" + uses +"]";
		}

}
