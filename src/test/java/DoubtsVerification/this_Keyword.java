package DoubtsVerification;

public class this_Keyword {
	String name;

	public static void main(String[] args) {
		this_Keyword obj1 = new this_Keyword("Av");
		this_Keyword obj2 = new this_Keyword();
		obj1.method01();
		obj2.method01();

	}
	
	private void method01() {
		System.out.println(this.name);
		System.out.println(this);
		
	}

	public this_Keyword() {
		this("Avdhut");
	}

	public this_Keyword(String value) {
		this.name = value;
	}

}
