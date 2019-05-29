package mooc_1;
import java.util.Scanner;

public class test { 
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    // Ask for text
    System.out.print("Write text: ");
    String text = input.nextLine();

    // Print normalized text
    text = normalizeText(text);
    System.out.println("Normalized text: " + text);

    // Ask for shift value
    System.out.print("Shift value: ");
    int shiftValue = input.nextInt();
    input.nextLine();

    // Print Caesar Cipher
    System.out.println("Caesar Cipher: " + caesarify(text, shiftValue));

    // Ask for codegroups
    System.out.print("Code groups: ");
    int groupSize = input.nextInt();
    input.nextLine();

    // Print Encrypted 
    System.out.println("Encrypted text: " + encryptString(text, shiftValue, groupSize));

    // Print Decrypted
    System.out.println("Ungroupified text: " + ungroupify(encryptString(text, shiftValue, groupSize)));
    System.out.println("Decrypted Text: " + decryptString(ungroupify(encryptString(text, shiftValue, groupSize)), shiftValue));

}

// Part One: Normalize Text
public static String normalizeText(String text) {
    String temp = "";
    // Remove any punctuation (. , : ; ’ ” ! ? ( ) )
    temp = text.replaceAll("[\\s.,:;'!?()\"]", "");
    // Turn all lower-case letters into upper-case letters
    temp = temp.toUpperCase();
    // Return temp
    return temp;
}

// Part 2: Caesar Cipher
public static String caesarify(String text, int shiftValue){
    String temp = "";
    // For every character in "text"...
    for(int i = 0; i < text.length(); i++){
        // Shifts current character by shift value
        char currentChar = (char)(text.charAt(i) + shiftValue);
        // If current character exceeds "Z," it must "wrap around"
        if (currentChar > 'Z')
            temp += (char)(text.charAt(i) - 26 + shiftValue);
        else
            temp += (char)(text.charAt(i) + shiftValue);
    }
    return temp;
}

// Part 3: Codegroups
public static String groupify(String text, int groupSize) {
    String temp = "";
    for(int i = 0; i < text.length(); i++) {
        // If a group is made, adds a space between the letters
        if(i % groupSize == 0 && i != 0) {
            temp = temp + " ";
        }
        temp = temp + text.charAt(i);
    }
    // Total number of groups
    int totalgroups = (int) Math.ceil((float) text.length() / groupSize);   
    // Check if x's are needed
    if((text.length()) % groupSize != 0) {
        // Total number of letters
        int totalLetters = totalgroups * groupSize;
        // Check how many x's are needed
        int numberOfX = totalLetters - text.length();
        // Adds correct number of x's
        for(int i = 0; i < numberOfX; i++) {
            temp = temp + "x";
        }
    }
    return temp;
}

// Part 4: Putting it all together
public static String encryptString(String text, int shiftValue, int groupSize) {
    String temp = "";
    temp = normalizeText(text);
    temp = caesarify(temp, shiftValue);
    temp = groupify(temp, groupSize);
    return temp;
}

// Part 5: Hacker Problem - Decrypt
public static String ungroupify(String groupedText) {
    String temp = "";
    // Remove x's and spaces
    temp = groupedText.replaceAll("[ x]", "");
    return temp;
}

public static String decryptString(String encryptedText, int shiftValue)
{
    String temp = "";
    // For every character in "text"...
    for(int i = 0; i < encryptedText.length(); i++){
        // Shifts current character in reverse by shift value
        char currentChar = (char)(encryptedText.charAt(i) - shiftValue);
        // If current character exceeds "Z," it must "wrap around"
        if (currentChar < 'A')
            temp += (char)(encryptedText.charAt(i) + 26 - shiftValue);
        else
            temp += (char)(encryptedText.charAt(i) - shiftValue);
    }
    return temp;
}   
}