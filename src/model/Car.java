package model;
	

public class Car extends Vehicle implements Gasoline, Electric, Hybrid{
	
	private CarType type;
	private int doors;
	private boolean isPolarized;
	private int typeC;
	
	
  public Car(int basePrice, int soldPrice, String marca, String model, int cylinderCapacity, int km, boolean isNew, String id, int type, int doors, boolean isPolarized, int typeC) {
	  super(basePrice, soldPrice, marca, model, cylinderCapacity, km, isNew, id);
	  
	  switch(type) {

      case 1:
      this.type=CarType.SEDAN;
      break;

      case 2:
      this.type=CarType.PICKUP_TRUCK;
      break;
	  }
      
	  this.doors = doors;
	  this.isPolarized = isPolarized;
  }


public int getTypeC() {
	return typeC;
}


public void setTypeC(int typeC) {
	this.typeC = typeC;
}


public CarType getType() {
	return type;
}


public void setType(CarType type) {
	this.type = type;
}


public int getDoors() {
	return doors;
}


public void setDoors(int doors) {
	this.doors = doors;
}


public boolean isPolarized() {
	return isPolarized;
}


public void setPolarized(boolean isPolarized) {
	this.isPolarized = isPolarized;
}


@Override
public int HybridG(int gasoline, int capacity) {
	int consume = capacity * (getCylinderCapacity()/180);
	return consume;
}

@Override
public int HybridE(int charged, int capacity) {
	int consume = 0;
	if(charged == 1) {
		consume = capacity * (getCylinderCapacity() / 200);
	}else {
		consume = (capacity + 7) * (getCylinderCapacity() / 200);
	}
	return consume;
}


@Override
public int consumeE(int charge, int duration) {
	int consume = 0;
	
	if(charge == 1) {
		consume = (duration + 13) * (getCylinderCapacity()/100);
	}else {
		consume = (duration + 18) * (getCylinderCapacity()/100);
	}
	return consume;
}


@Override
public int consumeG(int gasoline, int capacity) {
	int consume = capacity * (getCylinderCapacity() / 150);
	return consume;
}



  
  
}