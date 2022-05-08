package gr.aueb.cf.testbed.projectsA.projects;

import java.util.Arrays;

public class Project09 {

    public static void main(String[] args) {


        String message = "This is an encrypted message.#";
        String encryptedMessage = "84188209220147137220147129207142133211209213235233228217201132141210216230212200204147-1";
        final int key = 6876;

       // encryptionProgram (message,key);

        decryptionProgram(encryptedMessage,key);


    }

    public static void encryptionProgram (String message,int key) {

        for (int i = 0; i < message.length(); i++) {

            int currentCharNo = 0;
            int previousCharNo = 0;
            int encodedChar = 0;
            String encodedMessage ="";
            int cipher = 0;


            if (i == 0) {

                cipher = message.charAt(i);
                encodedMessage = cipher + encodedMessage;

            } else {

                if (message.charAt(i) == 35) {
                    encodedMessage = encodedMessage +"-1";
                    i =  message.length();
                    System.out.print(encodedMessage);
                    break;


                }

                previousCharNo = message.charAt(i-1);
                currentCharNo = message.charAt(i);

                encodedChar = (currentCharNo + previousCharNo) % key;
                encodedMessage = encodedMessage + encodedChar;
            }

            System.out.print(encodedMessage);
        }
    }

    public static void decryptionProgram (String encryptedMessage,int key) {

        String charSearcher="";
        int currentCharReadNo = 0;
        int nextCharNo = 0;
        String decodedMessage = "";
        int cipher = 84;
        int rangeLow = 0;
        int rangeHigh = 128;

        for (int i = 0; i < encryptedMessage.length(); i++) {

            charSearcher = charSearcher + encryptedMessage.charAt(i);

            if (encryptedMessage.charAt(i) != (char)45) {
                currentCharReadNo = Integer.parseInt(charSearcher);
            } else {
                decodedMessage = decodedMessage + "#";
                System.out.println("-------DECODED MESSAGE--------");
                System.out.println(decodedMessage);
                break;

            }

            System.out.println("1 READ CHAR " + charSearcher);
            nextCharNo = (currentCharReadNo - cipher) % key;
            System.out.println("2 NEXT CHAR TO SEARCH " + nextCharNo);
            System.out.println();

            if (currentCharReadNo == cipher) {
                decodedMessage = decodedMessage + (char) Integer.parseInt(charSearcher);
                System.out.println("DECODED MSG!! " + decodedMessage);
                System.out.println("DECODED CAR ASCII " + currentCharReadNo);
                System.out.println("NEXT CHAR TO SEARCH " + nextCharNo);
                charSearcher ="";
                rangeLow = rangeLow ;
                rangeHigh = rangeHigh + cipher;
                //cipher = cipher + nextCharNo;
                System.out.println("SIPH NEW "+cipher);
                System.out.println("NEXT RANGE, LOW: "+rangeLow+" HIGH: "+rangeHigh);
                System.out.println();

            } else if ((nextCharNo >= rangeLow) && (nextCharNo <= rangeHigh)) {
                System.out.println("MATCH! "+nextCharNo);
                decodedMessage = decodedMessage + (char)nextCharNo;

                System.out.println("DEC MSG!! " + decodedMessage);
                System.out.println("DEC CAR " + currentCharReadNo);
                charSearcher ="";
                cipher = nextCharNo;
                rangeLow = rangeLow ;
                rangeHigh = rangeHigh + cipher;
                System.out.println("NEXT RANGE, LOW: "+rangeLow+" HIGH: "+rangeHigh);

                System.out.println("SIPH NEW "+cipher);

                System.out.println();

            }
        }
    }


}
