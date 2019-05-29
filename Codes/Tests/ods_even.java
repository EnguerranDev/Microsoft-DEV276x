package mooc_1;
import java.util.*;

public class ods_even {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.print("Let’s play a game called “Odds and Evens”");
    	System.out.print("\nWhat is your name?");
    	String name = input.nextLine();
    	System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens?");
    	String o_e = input.nextLine();
        if (o_e.equals("O")) {
        	System.out.print(name + " has picked odds! The computer will be evens.");
        }  else {
        	System.out.print(name + " has picked evens! The computer will be odds.");
        }
        System.out.print("\n-------------------------");
        
    	System.out.print("\nHow many “fingers” do you put out?");
    	int user = input.nextInt();
    	// computer picks
    	Random rand = new Random();
    	int computer = rand.nextInt(6);
    	System.out.print("The computer plays " + computer + " \"fingers\" ");
    	System.out.print("\n-------------------------");
    	
    	// sum
    	int suma = user + computer;
    	System.out.print("\n" + user + " + " + computer + " = " + suma);
    	
    	// is sum odd or even
    	String result;
    	String first;
    	if (suma%2 == 0) {
    		result = "Even";
    		first = "E";
    	} else {
    		result = "Odd";
    		first = "O";
    	}
    	
    	System.out.print("\n" + suma + " is ..." + result + "!");
    	
    	
    	// who won
    	if (o_e.equals(first)){
    		System.out.print("\nThat means that " + name + " wins");
    	} else {
    		System.out.print("\nThat means that Computer wins");
    	}
    	System.out.print("\n-------------------------");
    }
}
