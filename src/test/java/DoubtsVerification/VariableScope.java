package DoubtsVerification;

public class VariableScope {

	static int globalNum;
	static String globalStr;
	static boolean globalBoool;
	static char globalChar;

	public static void main(String... args) {
		int localVar;
		System.out.println(globalNum);
		System.out.println(globalStr);
		System.out.println(globalBoool);
		System.out.println("char default value is: " + globalChar);
//		System.out.println(localVar);   The local variable localVar may not have been initialized
	}

}
