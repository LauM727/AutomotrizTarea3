package model;

import java.util.ArrayList;

public class Concesionary{
	
	private Vehicle[][] parking;
    
    private String name;
    
    public Concesionary(){
        
        parking = new Vehicle[10][4];

    }

	public Vehicle[][] getParking() {
		return parking;
	}

	public void setParking(Vehicle[][] parking) {
		this.parking = parking;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String saveParking(Vehicle temp) {
		boolean isFull = false;
		String message = "";
		for(int i = 0; i<parking.length; i++) {
			for(int j = 0; j<parking[i].length; j++){
				if(Integer.parseInt(temp.getModel()) < 2015) {
					if(temp.getModel().equals("2014") && j == 0) {
						if(parking[i][j] == null) {
							parking[i][j] = temp;
							message = "Saved in (" + i + "," + j + ")";
							break;
						}else {
							isFull = true;
							message = "I cant saved, you should grow up the parking";
							break;
						}
					}else if(temp.getModel().equals("2013") && j == 1) {
						if(parking[i][j] == null) {
							parking[i][j] = temp;
							message = "Saved in (" + i + "," + j + ")";
							break;
						}else {
							isFull = true;
							message = "I cant saved, you should grow up the parking";
							break;
						}
					}else if(temp.getModel().equals("2012") && j == 3) {
						if(parking[i][j] == null) {
							parking[i][j] = temp;
							message = "Saved in (" + i + "," + j + ")";
							
							break;
						}else {
							isFull = true;
							message = "I cant saved, you should grow up the parking";
							break;
						}
					}else if(Integer.parseInt(temp.getModel()) < 2011 && j == 4) {
						if(parking[i][j] == null) {
							parking[i][j] = temp;
							message = "Saved in (" + i + "," + j + ")";
							break;
						}else {
							isFull = true;
							message = "I cant saved, you should grow up the parking";
							break;
						}
					}
				}else {
					message = "I cant saved, only can save model < 2015";
				}
			}
		}
		return message;
	}
	
	public String getInfoVehicle(Vehicle temp) {
		String info = "";
		if(temp instanceof Car) {
			info = "**Car**" + "/n" +
					"PLACA: " + temp.getId() + "/n" +
					"KM: " + temp.getKm() + "/n" +
					"MARCA: " + temp.getMarca() + "/n" +
					"MODELO: " + temp.getModel();
					
		}else {
			info = "**MotorBike**" + "/n" +
					"PLACA: " + temp.getId() + "/n" +
					"KM: " + temp.getKm() + "/n" +
					"MARCA: " + temp.getMarca() + "/n" +
					"MODELO: " + temp.getModel();
		}
		return "";
	}
	
	public String searchVechicle(String model) {
		String message = "";
		for(int i = 0; i<parking.length; i++) {
			for(int j = 0; j<parking[i].length; j++) {
				if(Integer.parseInt(model) < 2015) {
					if(model.equals("2014") && i == 0) {
						if(parking[i][j] == null) {
							
						}else {
							message += "(" + i + "," + j + ")" +getInfoVehicle(parking[i][j]);
						}
					}else if(model.equals("2013") && i == 1) {
						if(parking[i][j] == null) {
							
						}else {
							message += "(" + i + "," + j + ")" +getInfoVehicle(parking[i][j]);
						}
						
					}else if(model.equals("2012") && i == 2) {
						if(parking[i][j] == null) {
							
						}else {
							message += "(" + i + "," + j + ")" +getInfoVehicle(parking[i][j]);
						}
						
					}else if(Integer.parseInt(model) < 2011 && i == 2) {
						if(parking[i][j] == null) {
							
						}else {
							message += "(" + i + "," + j + ")" +getInfoVehicle(parking[i][j]);
						}
						
					}
				}
				message = "No cars with this model";
				
			}
		}
		return message;
	}
    
    

 
}