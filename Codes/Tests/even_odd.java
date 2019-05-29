package mooc_1;
import java.util.Scanner;
import java.lang.Math;


public class even_odd {

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
        System.out.print("Give a number?");
        int nb = input.nextInt();
        if (nb%2 == 0) {
        	System.out.print("Even");
        }  else {
        	System.out.print("Odd");
        }
    }
}
