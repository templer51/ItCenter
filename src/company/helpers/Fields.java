package company.helpers;

public enum Fields {
	
	NAME("name"), AGE("age"), ADDRESS("addres"), PHONE("phone");
	
	private String value;
	
	private Fields(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}

}
