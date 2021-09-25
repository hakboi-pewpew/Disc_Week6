// Name: Luttrell, Bryan		CMIS 141/6382		Date: 09/22/2021 <-- creation date
// Week 6 - Methods

// Libraries
import java.util.Scanner;

/**
*	This is a ROT cipher. A ROT cipher is a rotational cipher. It takes a string from a user, and asks for a number to
*	shift (1-26), and shifts the alphabet by that amount. It is a fairly simple encoding scheme you may see in some basic
*	CTF (Capture the flag) challenges; this goes with the theme of the week from the Professor about cyber challenges.
*	Enjoy!
*	@author Bryan Luttrell
*	@version %I%, %G%
*/

public class DiscWeek6_fixed{
	
	/**
	*	Encode the user-entered string with a rotational cipher.
	*	@param msg	The original message from the user as a <b><i>string</i></b>
	*	@param shift	The rotational shift of the cipher as a <b><i>byte</i></b>
	*/
	
	private static String encodeROT(String msg, byte shift){
		byte[] origMsg = msg.getBytes(); // original message typed by the user
		String encodedMsg = ""; // final encoded message displayed to user
	
	        for (int a : origMsg) {
			if (a >= 97 && a <= 122){
				// Store the shifted value of the character into the encoded string
				encodedMsg += ((a + shift) <= 122) ? (char)(byte) (a + shift) : (char)(byte) ((a + shift) - 26);
				// The below decimal values are special character ranges in the ascii table
			} else if ((a >= 32 && a <= 64) || (a >= 91 && a <= 96) || (a >= 123 && a <= 126)){
				encodedMsg += (char) a; // if the byte is not an ascii a-z, print out the actual character
			}
	        }
		return encodedMsg; // send the message back to the call
	}

	public static void main(String[] args){
		// Declare variables and create print strings
		String classInfo = "\nName: Luttrell, Bryan\t\tCMIS 141/6382\t\tDate: 09/22/2021\n";

		String banner = 
		 "\t\t\t/./../././    0000000000    TTTTTTTTTT\n"
		+"\t\t\t/./    /./    000    000        TT\n"
		+"\t\t\t/./    /./    000    000        TT\n"
		+"\t\t\t/./.././      000    000        TT\n"
		+"\t\t\t/./   /./     000    000        TT\n"
		+"\t\t\t/./    /./    000    000        TT\n"
		+"\t\t\t/./     /./   0000000000        TT\tv1.3.0";
		
		String desc =
		"This is a ROT cipher. A ROT cipher is a rotational cipher. It takes a string from a user\n"
		+"and asks for a number to shift (1-26), and shifts the alphabet by that amount. It is a\n"
		+"fairly simple encoding scheme you may see in some basic CTF (Capture the flag) challenges\n"
		+"which goes with the theme of the week from the Professor about cyber challenges. Enjoy!";

	        String error = "INPUT VALIDATION ERROR -- You must enter a value between 1 and 26!\nWhat would you like the shift to be (1-26)? ";

	        Scanner scanStr = new Scanner(System.in);
	        Scanner scanByte = new Scanner(System.in);
	        byte shift = 0;
	        String line = "*";          
		String encMsg = null;
		String oldMsg = "";
	
		// Print class header
		System.out.println(classInfo);
	
	        // Print program information
	        System.out.println("\n" + line.repeat(90) + "\n"); // repeat decorations
	        System.out.println(banner + "\n"); // print the ROT banner
	        System.out.println(desc); // print the program description
	        System.out.println("\n" + line.repeat(90) + "\n"); // repeat decorations

		// Get input from user
		while (oldMsg.equals("")) {
		        System.out.print("Enter a message to encode with ROT: ");
			oldMsg = scanStr.nextLine().toLowerCase();
		}
		
	        System.out.print("What would you like the shift to be (1-26)? ");
	        while (shift <= 0 || shift > 26) {
	                while (!scanByte.hasNextByte()) {
	                        System.out.print(error);
	                        scanByte.next();
	                }
	                shift = scanByte.nextByte();
	                if (shift <= 0 || shift > 26){
	                        System.out.print(error);
	                }
	        } 
		
		// Call the encoding method
		encMsg = encodeROT(oldMsg, (byte)shift);
		
		// Print the message out!
	        System.out.println("\n" + line.repeat(90) + "\n"); // repeat decorations
		System.out.println(oldMsg + "\nwas changed to the below using a ROT-" + shift + " cipher!\n" + encMsg);
	        System.out.println("\n" + line.repeat(90) + "\n"); // repeat decorations

		// Close scanners
		scanStr.close();
		scanByte.close();
	}
}
