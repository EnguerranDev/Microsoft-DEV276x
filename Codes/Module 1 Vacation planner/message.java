package mooc_1;
import java.util.Scanner;
import java.lang.Math;

public class message {
    public static void main(String[] args) {
    	//greetings();
    	//calculations();
    	distance();
    }
    
    public static void greetings() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner");
        System.out.print("What is your name?");
        String name = input.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to?");
        String to_travel = input.nextLine();
        System.out.print("Great! " + to_travel + " sounds like a great trip");
        System.out.print("\n***********");
    }
    
    
    public static void calculations() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("How many days are you going to spend travelling?");
        int nb_days = input.nextInt();
        System.out.print("How much money, in USD are you planning to spend on your trip?");
        double money_usd = input.nextDouble();
        System.out.print("What is the three letter currency symbol for your travel destination");
        String curr_pair = input.next();
        System.out.print("How many " + curr_pair + " are there in 1 USD?");
        double exchange_rate = input.nextDouble();
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("If you are travelling for " + nb_days + " that is the same as " + nb_days*24 + " hours or " + nb_days*24*60 + " minutes");
        System.out.print("\nIf you are going to spend $" + money_usd + " USD that means per day you can spend up to $" + round_two_digit(money_usd/nb_days) + " USD");
        System.out.print("\nYour total budget in " + curr_pair + " is " + round_two_digit(money_usd*exchange_rate) + " " + curr_pair + ", which per day is " + round_two_digit(money_usd*exchange_rate/nb_days) + " " + curr_pair);
        System.out.print("\n***********");
    }
    
    
    public static void distance() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n");
        System.out.print("\n");

        System.out.print("Latitude from");
        double lat_from = input.nextDouble();
        System.out.print("Longitude from");
        double long_from = input.nextDouble();
        
        System.out.print("Latitude to");
        double lat_to = input.nextDouble();
        System.out.print("Longitude to");
        double long_to = input.nextDouble();

        double lon1 = Math.toRadians(long_from);
        double lat1 = Math.toRadians(lat_from);
        double lon2 = Math.toRadians(long_to);
        double lat2 = Math.toRadians(lat_to);
        
        double dLong = lon2 - lon1;
        double dLat = lat2 - lat1;
        
        double a = Math.pow(Math.sin(dLat/2),2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLong/2),2);
        double c = 2 * Math.asin(Math.sqrt(a));
        
        double final_dist = c * 6371;
        System.out.print("Your distance is " + round_two_digit(final_dist));
        System.out.print("\n***********");
    }
    
    
    // to round to two digits
    public static double round_two_digit(double x){
        double y;
        double rounded;
        y = x * 100.0;
        rounded = (int) y;
        rounded = rounded / 100.0;
    	return rounded;
      }
    
}
