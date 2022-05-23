package model;

import java.util.ArrayList;

public class Vehicle{
   
	//Attributes
	
	private int basePrice;
	private int soldPrice;
	private String marca;
	private String model;
	private int cylinderCapacity;
	private int km;
	private boolean isNew;
	private String id;
	private boolean haveDocument;
	
	//Relation
	
	private ArrayList<Document> documents;
	
	//Constructor method
	
	public Vehicle(int basePrice, int soldPrice, String marca, String model, int cylinderCapacity, int km, boolean isNew, String id) {
		this.basePrice = basePrice;
		this.soldPrice = soldPrice;
		this.marca = marca;
		this.model = model;
		this.cylinderCapacity = cylinderCapacity;
		this.km = km;
		this.isNew = isNew;
		this.id = id;
		documents = new ArrayList<>();
		haveDocument = false;
	}
	
	

	public boolean isHaveDocument() {
		return haveDocument;
	}



	public void setHaveDocument(boolean haveDocument) {
		this.haveDocument = haveDocument;
	}



	public ArrayList<Document> getDocuments() {
		return documents;
	}



	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}



	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public int getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(int soldPrice) {
		this.soldPrice = soldPrice;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCylinderCapacity() {
		return cylinderCapacity;
	}

	public void setCylinderCapacity(int cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}