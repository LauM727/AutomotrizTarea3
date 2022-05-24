package ui;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import model.*;

public class Main {
	
	private static Concesionary concesionary;
	private static Scanner lector;
	private static Scanner lectorS;

	public static void main(String[] args) {
		concesionary = new Concesionary();
		lector = new Scanner(System.in);
		lectorS = new Scanner(System.in);
		//int basePrice, int soldPrice, String marca, String model, int cylinderCapacity, int km, boolean isNew, String id, int type
		Motorcycle a1 = new Motorcycle(2,2,"Susuki", "2013", 2, 200, false, "PTM-359", 1);
		Motorcycle a2 = new Motorcycle(2,2,"Susuki", "2012", 2, 200, false, "PTM-358", 1);
		Motorcycle a3 = new Motorcycle(2,2,"Susuki", "2014", 2, 200, false, "PTM-357", 1);
		Car b1 = new Car(2, 2, "Chevrolet", "2012", 2, 100, false, "PTM-352", 1, 4, true, 1);
		Car b2 = new Car(2, 2, "Mazda", "2012", 2, 100, false, "PTM-351", 1, 4, true, 2);
		Car b3 = new Car(2, 2, "Mazda", "2012", 2, 0, true, "PTM-351", 1, 4, true, 2);
		System.out.println(concesionary.saveParking(a1));
		System.out.println(concesionary.saveParking(a2));
		System.out.println(concesionary.saveParking(a3));
		System.out.println(concesionary.saveParking(b1));
		System.out.println(concesionary.saveParking(b2));
		System.out.println(concesionary.saveParking(b3));
		menu();	
	}
	
	public static void menu() {
		System.out.println("Welcome");
		System.out.println("MENU");
		System.out.println("1. Register a vehicle");
		System.out.println("2. Calculate the total selling of a vehicle");
		System.out.println("3. Generate reports of vehicles");
		System.out.println("4. Generate state of documents based on id of vehicle");
		System.out.println("5. Generate map of free spaces of parking");
		System.out.println("6. Generate reports about ocupation of parking");
		System.out.println("7. Grow up the parking");
		System.out.println("---------------------------------------------------");
		System.out.println("Select a option");
		
		int answer = lector.nextInt();
		
		if(answer == 1) {
			option1();
		}else if(answer == 2) {
			option2();
		}else if(answer == 3) {
			option3();
		}else if(answer == 4) {
			option4();
		}else if(answer == 5) {
			option5();
		}else if(answer == 6) {
			option6();
		}else if(answer == 7) {
			option7();
		}else {
			System.out.println("Incorrect option, please try again");
			menu();
		}
		
	}
	
	public static void option1() {
		System.out.println("What vehicle do you want register? [1] Car [2] Motorbike");
		int answer = lector.nextInt();
		if(answer == 1) {
			System.out.println("The car is new? [1] Yes [2] No");
			int answer2 = lector.nextInt();
			if(answer2 == 1) {
				//int basePrice, int soldPrice, String marca, String model, int cylinderCapacity, int km, boolean isNew, String id, int type, int doors, boolean isPolarized
				System.out.println("What is the base price of vehicle?");
				int baseP = lector.nextInt();
				System.out.println("What is the sold price of vehicle?");
				int soldP = lector.nextInt();
				System.out.println("What is the brand of vehicle?");
				String brand = lectorS.nextLine();
				System.out.println("What is the model of vehicle?");
				String model = lectorS.nextLine();
				System.out.println("What is the cylinder capacity of vehicle?");
				int cylinder = lector.nextInt();
				Random random = new Random();
				String placaL = "";
				for(int i = 0; i<3; i++) {
					char randomChar = (char) (random.nextInt(23) + 'a');
					placaL += randomChar + "";
				}
				
				String placaN = "";
				for(int i = 0; i<3; i++) {
					int num = random.nextInt(9);
					placaN += num + "";
				}
				
				String id = placaL.toUpperCase() + "-" + placaN;
				
				System.out.println("How many doors have the vehicle");
				int door = lector.nextInt();
				System.out.println("The vehicle is polarized? [1] Yes [2] No");
				int isPolarized = lector.nextInt();
				boolean isPolarized2 = false;
				if(isPolarized == 1) {
					isPolarized2 = true;
				}
				
				System.out.println("What type of car is? [1] Sedan [2] PICKUP-TRACK");
				int type = lector.nextInt();
				Vehicle temp;
				if(type == 1) {
					System.out.println("What type of combustible have? [1] Gasoline [2] Electric [3] Hibrid");
					int answer3 = lector.nextInt();
					if(answer3 == 1) {
						temp = new Car(baseP, soldP, placaN, model, cylinder, 0, true, id, type, door, isPolarized2, answer3);
						System.out.println(concesionary.saveParking(temp));
						System.out.println("The vehicle is registered with the id: " + temp.getId());
						menu();
					}else if(answer3 == 2) {
						temp = new Car(baseP, soldP, placaN, model, cylinder, 0, true, id, type, door, isPolarized2, answer3);
						System.out.println(concesionary.saveParking(temp));
						System.out.println("The vehicle is registered with the id: " + temp.getId());
						menu();
					}else if(answer3 == 3){
						temp = new Car(baseP, soldP, placaN, model, cylinder, 0, true, id, type, door, isPolarized2, answer3);
						System.out.println(concesionary.saveParking(temp));
						System.out.println("The vehicle is registered with the id: " + temp.getId());
						menu();
					}else {
						
					}
					
					
				}else if(type == 2){
					System.out.println("What type of combustible have? [1] Gasoline [2] Electric [3] Hibrid");
					int answer3 = lector.nextInt();
					if(answer3 == 1) {
						temp = new Car(baseP, soldP, placaN, model, cylinder, 0, true, id, type, door, isPolarized2, answer3);
						System.out.println(concesionary.saveParking(temp));
						System.out.println("The vehicle is registered with the id: " + temp.getId());
						menu();
					}else if(answer3 == 2) {
						temp = new Car(baseP, soldP, placaN, model, cylinder, 0, true, id, type, door, isPolarized2, answer3);
						System.out.println(concesionary.saveParking(temp));
						System.out.println("The vehicle is registered with the id: " + temp.getId());
						menu();
					}else if(answer3 == 3){
						temp = new Car(baseP, soldP, placaN, model, cylinder, 0, true, id, type, door, isPolarized2, answer3);
						System.out.println(concesionary.saveParking(temp));
						System.out.println("The vehicle is registered with the id: " + temp.getId());
						menu();
					}else {
						
					}
				}
				
				
			}else {
				//int basePrice, int soldPrice, String marca, String model, int cylinderCapacity, int km, boolean isNew, String id, int type, int doors, boolean isPolarized
				System.out.println("What is the base price of vehicle?");
				int baseP = lector.nextInt();
				System.out.println("What is the sold price of vehicle?");
				int soldP = lector.nextInt();
				System.out.println("What is the brand of vehicle?");
				String brand = lectorS.nextLine();
				System.out.println("What is the model of vehicle?");
				String model = lectorS.nextLine();
				System.out.println("What is the cylinder capacity of vehicle?");
				int cylinder = lector.nextInt();
				System.out.println("What is the km of vehicle?");
				int km = lector.nextInt();
				Random random = new Random();
				String placaL = "";
				for(int i = 0; i<3; i++) {
					char randomChar = (char) (random.nextInt(23) + 'a');
					placaL += randomChar + "";
				}
				
				String placaN = "";
				for(int i = 0; i<3; i++) {
					int num = random.nextInt(9);
					placaN += num + "";
				}
				
				String id = placaL.toUpperCase() + "-" + placaN;
				
				System.out.println("How many doors have the vehicle");
				int door = lector.nextInt();
				System.out.println("The vehicle is polarized? [1] Yes [2] No");
				int isPolarized = lector.nextInt();
				boolean isPolarized2 = false;
				if(isPolarized == 1) {
					isPolarized2 = true;
				}
				
				System.out.println("What type of car is? [1] Sedan [2] PICKUP-TRACK");
				int type = lector.nextInt();
				Vehicle temp;
				if(type == 1) {
					System.out.println("What type of combustible have? [1] Gasoline [2] Electric [3] Hibrid");
					int answer3 = lector.nextInt();
					if(answer3 == 1) {
						temp = new Car(baseP, soldP, placaN, model, cylinder, km, false, id, type, door, isPolarized2, answer3);
						System.out.println(concesionary.saveParking(temp));
						System.out.println("The vehicle is registered with the id: " + temp.getId());
						menu();
					}else if(answer3 == 2) {
						temp = new Car(baseP, soldP, placaN, model, cylinder, km, false, id, type, door, isPolarized2, answer3);
						System.out.println(concesionary.saveParking(temp));
						System.out.println("The vehicle is registered with the id: " + temp.getId());
						menu();
					}else if(answer3 == 3){
						temp = new Car(baseP, soldP, placaN, model, cylinder, km, false, id, type, door, isPolarized2, answer3);
						System.out.println(concesionary.saveParking(temp));
						System.out.println("The vehicle is registered with the id: " + temp.getId());
						menu();
					}else {
						
					}
					
					
				}else if(type == 2){
					System.out.println("What type of combustible have? [1] Gasoline [2] Electric [3] Hibrid");
					int answer3 = lector.nextInt();
					if(answer3 == 1) {
						temp = new Car(baseP, soldP, placaN, model, cylinder, km, false, id, type, door, isPolarized2, answer3);
						System.out.println(concesionary.saveParking(temp));
						System.out.println("The vehicle is registered with the id: " + temp.getId());
						menu();
					}else if(answer3 == 2) {
						temp = new Car(baseP, soldP, placaN, model, cylinder, km, false, id, type, door, isPolarized2, answer3);
						System.out.println(concesionary.saveParking(temp));
						System.out.println("The vehicle is registered with the id: " + temp.getId());
						menu();
					}else if(answer3 == 3){
						temp = new Car(baseP, soldP, placaN, model, cylinder, km, false, id, type, door, isPolarized2, answer3);
						System.out.println(concesionary.saveParking(temp));
						System.out.println("The vehicle is registered with the id: " + temp.getId());
						menu();
					}else {
						
					}
				}
			}
		}else if(answer == 2) {
			//Motorcycle(int basePrice, int soldPrice, String marca, String model, int cylinderCapacity, int km, boolean isNew, String id, int type)
			System.out.println("The Motorcycle is new? [1] Yes [2] No");
			int answer2 = lector.nextInt();
			if(answer2 == 1) {
				System.out.println("What is the base price of vehicle?");
				int baseP = lector.nextInt();
				System.out.println("What is the sold price of vehicle?");
				int soldP = lector.nextInt();
				System.out.println("What is the brand of vehicle?");
				String brand = lectorS.nextLine();
				System.out.println("What is the model of vehicle?");
				String model = lectorS.nextLine();
				System.out.println("What is the cylinder capacity of vehicle?");
				int cylinder = lector.nextInt();
				Random random = new Random();
				String placaL = "";
				for(int i = 0; i<3; i++) {
					char randomChar = (char) (random.nextInt(23) + 'a');
					placaL += randomChar + "";
				}
				
				String placaN = "";
				for(int i = 0; i<2; i++) {
					int num = random.nextInt(9);
					placaN += num + "";
				}
				
				char randomChar = (char) (random.nextInt(23) + 'a');
				
				String a = randomChar + "";
				
				String id = placaL.toUpperCase() + "-" + placaN + a.toUpperCase();
				
				System.out.println("What is the type of motorbike [1] Standard, [2] Sport, [3] Scooter, [4] Cross");
				int answer3 = lector.nextInt();
				Vehicle temp;
				if(answer3 == 1) {
					temp = new Motorcycle(baseP, soldP, brand, model, cylinder, 0, true, id, answer3);
					System.out.println(concesionary.saveParking(temp));
					System.out.println("The vehicle is registered with the id: " + temp.getId());
					menu();
				}else if(answer3 == 2) {
					temp = new Motorcycle(baseP, soldP, brand, model, cylinder, 0, true, id, answer3);
					System.out.println(concesionary.saveParking(temp));
					System.out.println("The vehicle is registered with the id: " + temp.getId());
					menu();
				}else if(answer3 == 3) {
					temp = new Motorcycle(baseP, soldP, brand, model, cylinder, 0, true, id, answer3);
					System.out.println(concesionary.saveParking(temp));
					System.out.println("The vehicle is registered with the id: " + temp.getId());
					menu();
				}else if(answer3 == 4) {
					temp = new Motorcycle(baseP, soldP, brand, model, cylinder, 0, true, id, answer3);
					System.out.println(concesionary.saveParking(temp));
					System.out.println("The vehicle is registered with the id: " + temp.getId());
					menu();
				}
			}else {
				System.out.println("What is the base price of vehicle?");
				int baseP = lector.nextInt();
				System.out.println("What is the sold price of vehicle?");
				int soldP = lector.nextInt();
				System.out.println("What is the brand of vehicle?");
				String brand = lectorS.nextLine();
				System.out.println("What is the model of vehicle?");
				String model = lectorS.nextLine();
				System.out.println("What is the cylinder capacity of vehicle?");
				int cylinder = lector.nextInt();
				System.out.println("What is the km of vehicle?");
				int km = lector.nextInt();
				Random random = new Random();
				String placaL = "";
				for(int i = 0; i<3; i++) {
					char randomChar = (char) (random.nextInt(23) + 'a');
					placaL += randomChar + "";
				}
				
				String placaN = "";
				for(int i = 0; i<2; i++) {
					int num = random.nextInt(9);
					placaN += num + "";
				}
				
				char randomChar = (char) (random.nextInt(23) + 'a');
				
				String a = randomChar + "";
				
				String id = placaL.toUpperCase() + "-" + placaN + a.toUpperCase();
				
				System.out.println("What is the type of motorbike [1] Standard, [2] Sport, [3] Scooter, [4] Cross");
				int answer3 = lector.nextInt();
				Vehicle temp;
				if(answer3 == 1) {
					temp = new Motorcycle(baseP, soldP, brand, model, cylinder, km, false, id, answer3);
					System.out.println(concesionary.saveParking(temp));
					System.out.println("The vehicle is registered with the id: " + temp.getId());
					menu();
				}else if(answer3 == 2) {
					temp = new Motorcycle(baseP, soldP, brand, model, cylinder, km, false, id, answer3);
					System.out.println(concesionary.saveParking(temp));
					System.out.println("The vehicle is registered with the id: " + temp.getId());
					menu();
				}else if(answer3 == 3) {
					temp = new Motorcycle(baseP, soldP, brand, model, cylinder, km, false, id, answer3);
					System.out.println(concesionary.saveParking(temp));
					System.out.println("The vehicle is registered with the id: " + temp.getId());
					menu();
				}else if(answer3 == 4) {
					temp = new Motorcycle(baseP, soldP, brand, model, cylinder, km, false, id, answer3);
					System.out.println(concesionary.saveParking(temp));
					System.out.println("The vehicle is registered with the id: " + temp.getId());
					menu();
				}
			}
			
		}
	}
	
	public static void option5() {
		System.out.println(concesionary.printParking());
		menu();
	}
	
	public static void option4() {
		System.out.println("What is the ID of vehicle: Please enter the id like the example XXX-YYY or motorbike XXX-YYA where A is a other Letter and Y is a number");
		String answer = lectorS.nextLine();
		Vehicle temp = concesionary.searchInArray(answer);
		
		if(temp.isHaveDocument() == true) {
			PropertyCard card1 = (PropertyCard) temp.getDocuments().get(0);
			Soat soat1 = (Soat) temp.getDocuments().get(1);
			TechnicalReview tr = (TechnicalReview) temp.getDocuments().get(2);
			System.out.println(card1.printMatrix());
			System.out.println("PROPERTYCARD: " + card1.decode());
			System.out.println(soat1.printMatrix());
			System.out.println("SOAT: " + soat1.decode());
			System.out.println(tr.printMatrix());
			System.out.println("TechnicalReview: " + tr.decode());
		}else {
			Document card = new PropertyCard(2000, 2022);
			Document soat = new Soat(2000, 2022, 1000);
			Document review = new TechnicalReview(2000, 2022, 22);
			
			temp.getDocuments().add(card);
			temp.getDocuments().add(soat);
			temp.getDocuments().add(review);
			
			PropertyCard card1 = (PropertyCard) card;
			Soat soat1 = (Soat) soat;
			TechnicalReview tr = (TechnicalReview) review;
			System.out.println(card1.printMatrix());
			System.out.println("PROPERTYCARD: " + card1.decode());
			System.out.println(soat1.printMatrix());
			System.out.println("SOAT: " + soat1.decode());
			System.out.println(tr.printMatrix());
			System.out.println("TechnicalReview: " + tr.decode());
			temp.setHaveDocument(true);
			System.out.println("All images are save");
		}
		
		
		menu();
	}
	
	public static void option6() {
		System.out.println("[1] Listado de vehículos (y su información) dado un rango de años.");
		System.out.println("[2] Datos del vehículo más antiguo y más nuevo");
		System.out.println("[3] Porcentaje de ocupación del parqueadero");
		
		int answer = lector.nextInt();
		
		if(answer == 1) {
			System.out.println("Since what year do you want search? The first year is the >");
			int year1 = lector.nextInt();
			int year2 = lector.nextInt();
			System.out.println(concesionary.reportVehicleofRangeYear(year1, year2));
			menu();
		}else if(answer == 2) {
			System.out.println("List of vehicles order from oldest to youngest");
			ArrayList<Vehicle> vehicles = concesionary.listOfVehiclesofParking();
			Collections.sort(vehicles, new Comparator<Vehicle>() {
				@Override
				public int compare(Vehicle p1, Vehicle p2) {
					return new Integer(Integer.parseInt(p2.getModel())).compareTo(new Integer(Integer.parseInt(p1.getModel())));
				}
			});
			System.out.println(concesionary.reportMoreNewaOld(vehicles));
			menu();
			
		}else if(answer == 3) {
			System.out.println("El porcentaje de ocupacion del parqueadero es de: " + concesionary.averageParking() + "%");
			menu();
		}
	}
	
	public static void option3() {
		System.out.println("Generate reports of: [1] Type of vehicles, [2] Type of Combustible, [3] Used or new car");
		int answer = lector.nextInt();
		if(answer == 1) {
			System.out.println("Which elements do you want to see [1]Car, [2]Motorbyke");
			int answer2 = lector.nextInt();
			if(answer2 == 1) {
				System.out.println(concesionary.reportOfType(true));
				menu();
			}else if(answer2 == 2) {
				System.out.println(concesionary.reportOfType(false));
				menu();
			}
		}else if(answer == 2) {
			System.out.println("Which elements do you want to see [1] Gasoline, [2] Electric, [3]Hybrid");
			int answer2 = lector.nextInt();
			if(answer2 == 1) {
				System.out.println(concesionary.reportOfTypeC(answer2));
				menu();
			}else if(answer2 == 2) {
				System.out.println(concesionary.reportOfTypeC(answer2));
				menu();
			}else if(answer2 == 3) {
				System.out.println(concesionary.reportOfTypeC(answer2));
				menu();
				}
			}else if(answer == 3) {
			System.out.println("Which elements do you want to see: [1]New, [2]Used");
			int answer2 = lector.nextInt();
			if(answer2 == 1) {
				System.out.println(concesionary.reportOfVehicleNeworUsed(true));
				menu();
			}else if(answer2 == 2) {
				System.out.println(concesionary.reportOfVehicleNeworUsed(false));
				menu();
			}
		}
	}
	
	public static void option7() {
		System.out.println("Do you like grow up the parking? The actual size is: " + concesionary.getParking().length + "[1] Yes, [2]No");
		int answer = lector.nextInt();
		if(answer == 1) {
			System.out.println("What is the new size of matrix in rows, the new number should be > of the last size");
			int answer2 = lector.nextInt();
			System.out.println(concesionary.growUpMatrix(answer2));
			menu();
		}else {
			menu();
		}
	}
	
	public static void option2() {
		System.out.println(concesionary.reportAllVehicles());
		menu();
	}
	
	

}
