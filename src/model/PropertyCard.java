package model;

public class PropertyCard extends Document{
	
	public PropertyCard(double price, int year) {
		super(price, year);
		fillMatrix();
	}
	
	public String decode() {
		String message = "";
		for(int i = getPicture().length-1; i>=0; i--) {
			for(int j = getPicture().length-1 ; j>=0; j--) {
				if((i+j)%2 == 0) {
					message += getPicture()[i][j] + " ";
				}else{
					
				}
			}
		}
		
		return message;
	}

}
