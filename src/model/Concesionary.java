package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	
	public String growUpMatrix(int filas) {
		String message = "";
		Vehicle[][] newArray = new Vehicle[filas][4];
		if(filas >= parking.length) {
			for (int i = 0; i < parking.length; i++) {
				for (int j = 0; j < parking[i].length; j++) {
					if(parking[i][j] != null) {
						newArray[i][j] = parking[i][j];
					}
				}
			}
			message = "The new size is: " + filas;
		}else {
			message = "I cant grow up the parking because the number enter is < that the last size";
		}
		
		setParking(newArray);
		return message;
		
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
			message = "The vehicle cant save in the parking because is a > 2015 or is new, so i save in other space";
			otherCars.add(temp);
		}
		
		return message;
	}
	
	public String getInfoVehicle(Vehicle temp) {
		String info = "";
		String typeC = "";
		if(temp instanceof Car) {
			Car temp1 = (Car) temp;
			if(temp1.getTypeC() == 1) {
				 typeC = "Gasoline";
			}else if(temp1.getTypeC() == 2){
				typeC = "Electric";
			}else {
				typeC = "Hybrid";
			}
			info = "**Car**" + "\n" +
					"PLACA: " + temp.getId() + "\n" +
					"KM: " + temp.getKm() + "\n" +
					"MARCA: " + temp.getMarca() + "\n" +
					"MODELO: " + temp.getModel() + "\n" +
					"SOLD PRICE: " + temp.getSoldPrice() + "\n" +
					"TypeCombustible: " + typeC + "\n" + 
					"Type of Car: " + temp1.getType() + "\n" +
					"IsNew?: " + temp.isNew() + "\n" +
					"Price of sell: " + calculateTheTotalPrice(temp) + "\n";
					
		}else {
			Motorcycle temp1 = (Motorcycle) temp;
			info = "**MotorBike**" + "\n" +
					"PLACA: " + temp.getId() + "\n" +
					"KM: " + temp.getKm() + "\n" +
					"MARCA: " + temp.getMarca() + "\n" +
					"MODELO: " + temp.getModel() + "\n" +
					"SOLD PRICE: " + temp.getSoldPrice() + "\n" +
					"Type of Car: " + temp1.getType() + "\n" +
					"IsNew?: " + temp.isNew() + "\n" +
					"Price of sell: " + calculateTheTotalPrice(temp) + "\n";
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
	
	public ArrayList<Vehicle> listOfVehiclesofParking() {
		ArrayList<Vehicle> allVehicles = new ArrayList<>();
		String message = "";
		for (int i = 0; i < parking.length; i++) {
			for (int j = 0; j < parking[i].length; j++) {
				if(parking[i][j] != null) {
					allVehicles.add(parking[i][j]);
				}
			}
		}
		return allVehicles;
	}
	
	public String reportMoreNewaOld(ArrayList<Vehicle> vehicles) {
		String message = "";
		for (int i = 0; i < vehicles.size(); i++) {
			message += getInfoVehicle(vehicles.get(i)) + "\n";
		}
	return message;	
	}
	
	public String reportOfType(boolean a) {
		String message = "";	
		ArrayList<Vehicle> vehicles = listOfAllVehicles();
		if(a == true) {
			for (int i = 0; i < vehicles.size(); i++) {
				if(vehicles.get(i) instanceof Car) {
					message += getInfoVehicle(vehicles.get(i)) + "\n";
				}
			}
		}else {
			for (int i = 0; i < vehicles.size(); i++) {
				if(vehicles.get(i) instanceof Motorcycle) {
					message += getInfoVehicle(vehicles.get(i)) + "\n";
				}
			}
		}
		
		
		return message;
	}
	
	public String reportOfTypeC(int num) {
		String message = "";	
		ArrayList<Vehicle> vehicles = listOfAllVehicles();
			for (int i = 0; i < vehicles.size(); i++) {
				if(vehicles.get(i) instanceof Car) {
					Car temp = (Car) vehicles.get(i);
					if(num == 1) {
						if(temp.getTypeC() == 1) {
							message += getInfoVehicle(vehicles.get(i)) + "\n";
						}
					}else if(num == 2) {
						if(temp.getTypeC() == 2) {
							message += getInfoVehicle(vehicles.get(i)) + "\n";
						}
					}else if(num == 3) {
						if(temp.getTypeC() == 3) {
							message += getInfoVehicle(vehicles.get(i)) + "\n";
						}
					}
					
				}
			}
		
		return message;
	}
	
	public ArrayList<Vehicle> listOfAllVehicles() {
		ArrayList<Vehicle> allVehicles = new ArrayList<>();
		String message = "";
		for (int i = 0; i < parking.length; i++) {
			for (int j = 0; j < parking[i].length; j++) {
				if(parking[i][j] != null) {
					allVehicles.add(parking[i][j]);
				}
			}
		}
		
		for(int z = 0; z < otherCars.size(); z++) {
			allVehicles.add(otherCars.get(z));
		}
		return allVehicles;
	}
	
	public String reportOfVehicleNeworUsed(boolean a) {
		String message = "";	
		ArrayList<Vehicle> vehicles = listOfAllVehicles();
		if(a == true) {
			for (int i = 0; i < vehicles.size(); i++) {
				if(vehicles.get(i).isNew() == true) {
					message += getInfoVehicle(vehicles.get(i)) + "\n";
				}
			}
		}else {
			for (int i = 0; i < vehicles.size(); i++) {
				if(vehicles.get(i).isNew() == false) {
					message += getInfoVehicle(vehicles.get(i)) + "\n";
				}
			}
		}
		
		
		return message;
	}
	
	public double calculateTheTotalPrice(Vehicle temp) {
		double total = 0;
		if(temp.isHaveDocument() == true) {
			
			if(temp instanceof Car) {
				Car temp2 = (Car) temp;
				if(temp2.isNew() == false) {
					double suma2 = temp2.getBasePrice() - (temp2.getBasePrice() * 0.1);
					total += suma2;
					if(temp2.getTypeC() == 2) {
						double suma = temp2.getBasePrice() + (temp2.getBasePrice()*0.2);
						total += suma;
					}else if(temp2.getTypeC() == 3){
						double suma = temp2.getBasePrice() + (temp2.getBasePrice()*0.15);
						total += suma;
					}
				}else {
					if(temp2.getTypeC() == 2) {
						double suma = temp2.getBasePrice() + (temp2.getBasePrice()*0.2);
						total += suma;
					}else if(temp2.getTypeC() == 3){
						double suma = temp2.getBasePrice() + (temp2.getBasePrice()*0.15);
						total += suma;
					}
				}
				
			}else {
				Motorcycle temp2 = (Motorcycle) temp;
				if(temp2.isNew() == false) {
					double suma = temp2.getBasePrice() - (temp2.getBasePrice() * 0.02);
					double adicional = temp2.getBasePrice() + (temp2.getBasePrice() * 0.04);
					
					total += suma + adicional;
				}
				
			}
			
		}else {
			total += 500000;
			
			if(temp instanceof Car) {
				Car temp2 = (Car) temp;
				if(temp2.isNew() == false) {
					double suma2 = temp2.getBasePrice() - (temp2.getBasePrice() * 0.1);
					total += suma2;
					if(temp2.getTypeC() == 2) {
						double suma = temp2.getBasePrice() + (temp2.getBasePrice()*0.2);
						total += suma;
					}else if(temp2.getTypeC() == 3){
						double suma = temp2.getBasePrice() + (temp2.getBasePrice()*0.15);
						total += suma;
					}
				}else {
					if(temp2.getTypeC() == 2) {
						double suma = temp2.getBasePrice() + (temp2.getBasePrice()*0.2);
						total += suma;
					}else if(temp2.getTypeC() == 3){
						double suma = temp2.getBasePrice() + (temp2.getBasePrice()*0.15);
						total += suma;
					}
				}
				
			}else {
				Motorcycle temp2 = (Motorcycle) temp;
				if(temp2.isNew() == false) {
					double suma = temp2.getBasePrice() - (temp2.getBasePrice() * 0.02);
					double adicional = temp2.getBasePrice() + (temp2.getBasePrice() * 0.04);
					
					total += suma + adicional;
				}
				
			}
			
			
		}
		return total;
	}
	
	public String reportAllVehicles() {
		String message = "";	
		ArrayList<Vehicle> vehicles = listOfAllVehicles();
			for (int i = 0; i < vehicles.size(); i++) {
					message += getInfoVehicle(vehicles.get(i)) + "\n";
				}
			return message;
			}

 
}