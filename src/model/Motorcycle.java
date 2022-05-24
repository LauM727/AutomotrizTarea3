package model;

public class Motorcycle extends Vehicle{
	
	private MotorType type;
	
	public Motorcycle(int basePrice, int soldPrice, String brand, String model, int cylinderCapacity, int km, boolean isNew, String id, int type) {
		super(basePrice, soldPrice, brand, model, cylinderCapacity, km, isNew, id);
		
		switch(type) {

	      case 1:
	      this.type=MotorType.STANDARD;
	      break;
	      
	      case 2:
		  this.type=MotorType.SPORT;
		  break;
		  
	      case 3:
		  this.type=MotorType.SCOOTER;
		  break;
		      
	      case 4:
		  this.type=MotorType.CROSS;
		  break;
		  }
	}

	public MotorType getType() {
		return type;
	}

	public void setType(MotorType type) {
		this.type = type;
	}
	
	public int consume (int capacity) {
		int consume = capacity * (getCylinderCapacity()/75);
		return consume;
		
	}
	
	

}