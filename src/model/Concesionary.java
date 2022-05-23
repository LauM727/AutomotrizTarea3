package model;

import java.util.ArrayList;

public class Concesionary{
	
	private Vehicle[][] parking;
	private ArrayList<Vehicle> otherCars;
    
    private String name;
    
    public Concesionary(){
        
        parking = new Vehicle[10][4];
        otherCars = new ArrayList<>();

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
		String message = "";
		boolean isSaved = false;
		if(temp.isNew() == false && Integer.parseInt(temp.getModel()) < 2015) {
			for(int i = 0; i<parking.length && isSaved == false; i++) {
				for(int j = 0; j<parking[i].length && isSaved == false; j++) {
					if(Integer.parseInt(temp.getModel()) == 2014 && j == 0) {
						if(parking[i][j] == null) {
							parking[i][j] = temp;
							message = "The vehicle is save in: (" + i + "," + j + ")"; 
							isSaved = true;
						}else{
							message = "The vehicle cant save, please grow up the parking";
						}
					}else if(Integer.parseInt(temp.getModel()) == 2013 && j == 1) {
						if(parking[i][j] == null) {
							parking[i][j] = temp;
							message = "The vehicle is save in: (" + i + "," + j + ")"; 
							isSaved = true;
						}else{
							message = "The vehicle cant save, please grow up the parking";
						}
					}else if(Integer.parseInt(temp.getModel()) == 2012 && j == 2) {
						if(parking[i][j] == null) {
							parking[i][j] = temp;
							message = "The vehicle is save in: (" + i + "," + j + ")"; 
							isSaved = true;
						}else{
							message = "The vehicle cant save, please grow up the parking";
						}
					}else if(Integer.parseInt(temp.getModel()) <= 2011 && j == 3) {
						if(parking[i][j] == null) {
							parking[i][j] = temp;
							message = "The vehicle is save in: (" + i + "," + j + ")"; 
							isSaved = true;
						}else{
							message = "The vehicle cant save, please grow up the parking";
						}
					}
					
				}
			}
		}else {
			message = "The vehicle cant save because is a > 2015 or is new";
		}
		
		return message;
	}
	
	public String reportOfParking() {
		String message = "";
		for(int i = 0; i<parking.length; i++) {
			for(int j = 0; j<parking[i].length; j++) {
				if(parking[i][j] != null) {
					message += getInfoVehicle(parking[i][j]);
				}
			}
		}
		return message;
	}
	
	public String getInfoVehicle(Vehicle temp) {
		String info = "";
		if(temp instanceof Car) {
			info = "**Car**" + "\n" +
					"PLACA: " + temp.getId() + "\n" +
					"KM: " + temp.getKm() + "\n" +
					"MARCA: " + temp.getMarca() + "\n" +
					"MODELO: " + temp.getModel() + "\n";
					
		}else {
			info = "**MotorBike**" + "\n" +
					"PLACA: " + temp.getId() + "\n" +
					"KM: " + temp.getKm() + "\n" +
					"MARCA: " + temp.getMarca() + "\n" +
					"MODELO: " + temp.getModel() + "\n" ;
		}
		return info;
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
	
	public Vehicle searchInArray(String id) {
		Vehicle temp = null;
		boolean isFounded = false;
		for(int i = 0; i<parking.length && isFounded == false;i++) {
			for(int j= 0; j<parking[i].length && isFounded == false;j++) {
				if(parking[i][j]!=null) {
					if(parking[i][j].getId().equals(id)) {
						temp = parking[i][j];
						isFounded = true;
					}
					
				}
			}
		}
		if(temp == null) {
			for(int i = 0; i<otherCars.size(); i++) {
				if(otherCars.get(i).getId().equals(id)) {
					temp = otherCars.get(i);
				}
			}
		}
		return temp;
	}
	
	public String printParking() {
		String message = "";
		for(int i = 0; i<parking.length ; i++) {
			for(int j = 0; j<parking[i].length; j++) {
				if(parking[i][j] == null) {
					message += "[F] ";
				}else {
					message += "[B] ";
				}
			}
			message += "\n";
		}
		return message;
	}
	
	public String reportVehicleofRangeYear(int year1, int year2) {
		String message = "";
		for(int i = 0; i<parking.length; i++) {
			for(int j = 0; j<parking[i].length; j++) {
				if(parking[i][j] != null) {
					if(Integer.parseInt(parking[i][j].getModel()) <= year1 && Integer.parseInt(parking[i][j].getModel()) >= year2) {
						message += getInfoVehicle(parking[i][j]) + "\n";
					}
				}
			}
		}
		return message;
	}
	
	public int averageParking() {
		int busy = 0;
		for(int i = 0; i<parking.length; i++) {
			for(int j = 0; j<parking[i].length; j++) {
				if(parking[i][j] != null) {
					busy++;
				}
			}
		}
		
		int filas = parking.length;
		int columnas = parking[0].length;
		
		int size = filas * columnas;
		
		int average = (busy * 100) / size;
		return average;
	}
    

 
}