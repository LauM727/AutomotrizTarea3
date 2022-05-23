package model;

public class Soat extends Document{
	private int coverage;
	
	public Soat(double price, int year, int coverage) {
		super(price, year);
		this.coverage = coverage;
		fillMatrix();
	}

	public int getCoverage() {
		return coverage;
	}

	public void setCoverage(int coverage) {
		this.coverage = coverage;
	}
	
	public String decode() {
		String message = "";
		for(int i = 0; i<getPicture().length;i++) {
			for(int j = 0; j<getPicture()[i].length; j++) {
				if(i == getPicture().length-1) {
					message += getPicture()[i][j] + " ";
				}else {
					if(j < 1) {
						message += getPicture()[i][j] + " ";
					}else {
						break;
					}
				}
				
			}
		}
		return message;
	}
	
	
}
