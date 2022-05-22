package model;

public class TechnicalReview extends Document{
	
	private int gasLevel;
	
	public TechnicalReview(double price, int year, int gasLevel) {
		super(price, year);
		this.gasLevel = gasLevel;
	}

	public int getGasLevel() {
		return gasLevel;
	}

	public void setGasLevel(int gasLevel) {
		this.gasLevel = gasLevel;
	}
	
	public String decode() {
		String message = "";
		for(int i = 0; i<getPicture().length; i++) {
			for(int j =0; j<getPicture()[i].length; j++) {
				if(i == 0 || i == getPicture().length-1) {
					message += getPicture()[i][j] + " ";
				}else {
					if((i%2 == 0)) {
						if(j == (i-1)) {
							message += getPicture()[i][j] + " ";
							break;
						}
					}else {
						if(j == (i+1)) {
							message += getPicture()[i][j] + " ";
							break;
						}
					}
				}
			}
		}
		return message;
	}
	
	

}
