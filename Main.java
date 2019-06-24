import java.util.ArrayList;

public class Main {
	
	public static String replaceRepetitive(String input) {
		String output="";
		String temp ="";
		String[] a  = input.split(" ");
		ArrayList<String> b = new ArrayList<String>();
        for (String s: a) {
            b.add( s );
        }
        ArrayList<String> c = new ArrayList<String>();
		for (int i=0 ; i<b.size() ; i ++ ) {
			if (c.isEmpty()) {
				c.add(b.get(i));
				continue;
			}
			if ( c.get(c.size()-1).equals(b.get(i))) {
				temp = b.get(i);
				c.set(c.size()-1, "REPEAT");
			} else 
			if( c.get(c.size()-1).equals("REPEAT") && b.get(i).equals(temp) ) {
				continue;
			} else {
				c.add(b.get(i));
			}
		}
		for (String c1 : c) {
			output += c1 + " ";
		}
		return output;
	}
	
	public static void main(String[] args) {
		String[] testStr = {"I want want to to go go to the zoo",
				"I want to to go to the the the zoo",
				"i want to go go to the zoo",
				"i i want to go to the zoo"};
		
		String[] expectOutput = {"I REPEAT REPEAT REPEAT the zoo",
				"I want REPEAT go to REPEAT zoo",
				"i want to REPEAT to the zoo",
				"REPEAT want to go to the zoo"};
		
		for (int i = 0; i<testStr.length; i++) {
			System.out.println("Case :" + (i+1));
			System.out.println("Input: " + testStr[i]);
			System.out.println("Expect output: " + expectOutput[i]);
			System.out.println("Real output: " + replaceRepetitive(testStr[i]));
			System.out.println();
		}
	}

}
