package company.helpers;

public enum Fields {
	
	NAME("Name"), AGE("Age"), ADDRESS("Addres"), PHONE("Phone Number");
	
	private String value;
	
	private Fields(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
