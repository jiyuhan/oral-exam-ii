import java.util.Base64;
import java.util.Scanner;

/**
 * Created by thomas on 10/29/16.
 */
public class MorseCode {
    public enum morseCodes {
        A(".-", 'A'),
        B("-...", 'B'),
        C("-.-.", 'C'),
        D("-..", 'D'),
        E(".", 'E'),
        F("..-.", 'F'),
        G("--.", 'G'),
        H("....", 'H'),
        I("..", 'I'),
        J(".---", 'J'),
        K("-.-", 'K'),
        L(".-..", 'L'),
        M("--", 'M'),
        N("-.", 'N'),
        O("---", 'O'),
        P(".--.", 'P'),
        Q("--.-", 'Q'),
        R(".-.", 'R'),
        S("...", 'S'),
        T("-", 'T'),
        U("..-", 'U'),
        V("...-", 'V'),
        W(".--", 'W'),
        X("-..-", 'X'),
        Y("-.--", 'Y'),
        Z("--..", 'Z'),

        ONE(".----", '1'),
        TWO("..---", '2'),
        THREE("...--", '3'),
        FOUR("....-", '4'),
        FIVE(".....", '5'),
        SIX("-....", '6'),
        SEVEN("--...", '7'),
        EIGHT("---..", '8'),
        NINE("----.", '9'),
        ZERO("-----", '0');

        private String morseCode;
        private char romanLetter;

        morseCodes(String morse, char letter) {
            morseCode = morse;
            romanLetter = letter;

        }

        public String getMorseCode() {
            return morseCode;
        }
        public char getLetter() {
            return romanLetter;
        }
    }

    private String messageString;
    private String morseCodeString;
    private String decodedString;

    public void encodeMessage () {
        String messageUpperCase = this.messageString.toUpperCase();
        int messageLength = messageUpperCase.length();
        char[] messageUpperCaseCharArray = new char[messageLength];
        morseCodeString = "";

        for(int i = 0; i < messageLength; i++) {
            //System.out.format("insert %c to the char array%n", messageUpperCase.charAt(i));
            messageUpperCaseCharArray[i] = messageUpperCase.charAt(i);
            //System.out.format("%c%n", messageUpperCaseCharArray[i]);
        } // end for

        for(int i = 0; i < messageLength; i++) {
            for (morseCodes codes : morseCodes.values()) {

                //System.out.format("Char at: %c, enum at: %s %c. %n", messageUpperCaseCharArray[i], codes.getMorseCode(), codes.getLetter());
                if (messageUpperCaseCharArray[i] == codes.getLetter()) {
                    morseCodeString += codes.getMorseCode() + " ";
                    break;
                }
                else if(messageUpperCaseCharArray[i] == ' ') {
                    morseCodeString += "  ";
                    break;
                }
            } // end for
        } // end for

    } //end method

    private void decodeMessage () {
        int morseMessageLength = morseCodeString.length();
        char[] morseMessageCharArray = new char[morseMessageLength];
        String tempMorseCodeString = "";
        decodedString = "";
        for(int i = 0; i < morseMessageLength; i++) {
            morseMessageCharArray[i] = morseCodeString.charAt(i);
        }

        int spaceCounter = 0;
        for(int i = 0; i < morseMessageLength; i++) {
            //System.out.format("currently at morse code: %c", morseMessageCharArray[i]);
            if(morseMessageCharArray[i] == ' ') { // encounter's a space
                spaceCounter++;
                if(!tempMorseCodeString.isEmpty()) {
                    for (morseCodes codes : morseCodes.values()) {
                        if (codes.getMorseCode().equals(tempMorseCodeString)) {
                            decodedString += codes.getLetter();
                            tempMorseCodeString = "";
                            break;
                        }
                    }
                }
                if(spaceCounter == 3) {
                    decodedString += " ";
                    spaceCounter = 0;
                }
            }
            else {
                tempMorseCodeString += morseMessageCharArray[i];
                spaceCounter = 0;
            }
        }
    }

    public void setMessageString(String message) {
        this.messageString = message;
    }

    public String getMorseCodeString() {
        return this.morseCodeString;
    }

    public String getDecodedMessage() { return this.decodedString; }

    public static void main(String[] args) {
        MorseCode message1 = new MorseCode();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a phrase that you want to encode to: ");
        String inputMessage = scanner.nextLine();
        message1.setMessageString(inputMessage);

        message1.encodeMessage();

        System.out.format("Encoded morse code message: %s%n", message1.getMorseCodeString());

        message1.decodeMessage();
        System.out.format("Decoded message: %s%n", message1.getDecodedMessage());
    }
}