package model;

import java.util.Random;

public class Document{

    private double price;
    private int year;
    private int[][] picture;
    
    public Document(double price, int year) {
    	this.price = price;
    	this.year = year;
    	picture = new int[4][4];
    }

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int[][] getPicture() {
		return picture;
	}

	public void setPicture(int[][] picture) {
		this.picture = picture;
	}
	
	public String printMatrix() {
		String matrix = "";
		for(int i = 0; i<picture.length; i++) {
			for(int j = 0; j<picture[i].length; j++) {
				matrix += picture[i][j] + " ";
			}
			matrix += "/n";
		}
		
		return matrix;
	}
	
	public void fillMatrix() {
		for(int i = 0; i<picture.length; i++) {
			for(int j = 0; j<picture[i].length; j++) {
				Random rand = new Random();
				int maxNumber = 10;
				int randomNumber = rand.nextInt(maxNumber)+1;
				
				picture[i][j] = randomNumber;
			}
		}
	}
	
	
    
    

}