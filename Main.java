public class Main {
    public static void main(String[] args) {
    
    	String str1 = "test";
		String str2 = "test";
		String str3 = new String("test");
		String str4 = new String("test");
		
        System.out.println(str1==str3); //false		
    }
}