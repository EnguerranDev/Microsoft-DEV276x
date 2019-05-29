package mooc_1;
import java.lang.Math;

public class crypto {
	public static void main(String[] args) {
		// Parameters
		String initial_text = "This is some \"really\" great. (Text)!?";
		int shift = 1;
		int groups = 3;
		
		// Full process
		String cleaned_text = normalizeText(initial_text);
		String shifted = caesarify(cleaned_text,shift);
		String grouped = groupify(shifted,groups);
		String ungrouped = ungroupify(grouped);
		String decrypted = decryptString(ungrouped,shift);
		System.out.print("Initial Text\n");
		System.out.print(initial_text);
		System.out.print("\nCleaned Text\n");
		System.out.print(cleaned_text);
		System.out.print("\nEncrypted Text\n");
		System.out.print(shifted);
		System.out.print("\nGrouped Text\n");
		System.out.print(grouped);
		System.out.print("\nUngrouped Text\n");
		System.out.print(ungrouped);
		System.out.print("\nDecrypted Text\n");
		System.out.print(decrypted);
	}
	
	// Function to clean the string
	public static String normalizeText(String s) {
		// remove punctuation and normal characters
		String cleaned = s.replaceAll("[^a-zA-Z]", "");
		// uppercase
		return cleaned.toUpperCase();
	}
	
	// Function to encode the string
	public static String caesarify(String s, int shift) {
		String caesared = "";
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String encoded_alphabet = shiftAlphabet(shift);
		for (int i = 0 ; i < s.length() ; i++) {
			char to_encode = s.charAt(i);
			// get the index in current dictionnary
			int index_current = alphabet.indexOf(to_encode);
			// translate char
			char translated = encoded_alphabet.charAt(index_current);
			// add to final string
			caesared = caesared + translated;
		}
		return caesared;
	}
	
	// Function group the things in pairs on n characters (adding an x at the end)
	public static String groupify(String s, int groups) {
		String groupified = "";
		
		//start empty and add the chars add a space when modulos
		for (int i = 0 ; i < s.length() ; i++) {
			if (i%groups==0) {
				groupified = groupified + " ";
				groupified = groupified + s.charAt(i);
			} else {
				groupified = groupified + s.charAt(i);
			}
		}
		
		// Complete the last group.
		int len = s.length();
		int to_add = (int) Math.ceil((double) len/groups) * groups - len;
		for (int i = 1 ; i <= to_add ; i++) {
			groupified = groupified + "x";
		}
		return groupified.trim();
	}
	
	// Function to degroup and kill xs
	public static String ungroupify(String s) {
		// remove whitespaces
		String ungroupified = s.replaceAll("\\s", "");
		ungroupified = ungroupified.replaceAll("x", "");
		return ungroupified;
	}
		
	// Function to degroup and kill xs
	public static String decryptString(String s, int shift) {
		String uncaesared = "";
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String encoded_alphabet = shiftAlphabet(-shift);
		for (int i = 0 ; i < s.length() ; i++) {
			char to_encode = s.charAt(i);
			// get the index in current dictionnary
			int index_current = alphabet.indexOf(to_encode);
			// translate char
			char translated = encoded_alphabet.charAt(index_current);
			// add to final string
			uncaesared = uncaesared + translated;
		}
		return uncaesared;
	}
	
	// Function to apply a shift in the alphabet
	public static String shiftAlphabet(int shift) {
	    int start = 0;
	    if (shift < 0) {
	        start = (int) 'Z' + shift + 1;
	    } else {
	        start = 'A' + shift;
	    }
	    String result = "";
	    char currChar = (char) start;
	    for(; currChar <= 'Z'; ++currChar) {
	        result = result + currChar;
	    }
	    if(result.length() < 26) {
	        for(currChar = 'A'; result.length() < 26; ++currChar) {
	            result = result + currChar;
	        }
	    }
	    return result;
	}
}