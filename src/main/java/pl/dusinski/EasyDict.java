package pl.dusinski;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class EasyDict {
    //    private static String textPath = "/home/dd/test.txt";
    private static String textPath = "/home/dd/Pulpit/eng.txt";

    private static String textResult;


    public static void main(String[] args) {

        dictTable dt = new dictTable();
        String firstWord = "";
        String secondWord = "";
        Scanner scanner;
        String textLine;

        System.out.println("Hello world!");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(textPath));

//            StringBuilder stringBuilder = new StringBuilder();
            textLine = bufferedReader.readLine();


            while (textLine != null) {
                scanner = new Scanner(textLine).useDelimiter("[\\s]*[\\t]+[\\s]*");

                try {
//                    if (scanner.hasNext("[\\s]*[\\s]*")) {
                    firstWord = scanner.next();
                    secondWord = scanner.next();
                    dt.addTranslation(firstWord, secondWord);
//                    }

                } catch (NoSuchElementException e) {
//                    System.out.println("Empty line");
                }


//                stringBuilder.append(textLine);
//                stringBuilder.append(System.lineSeparator());
                textLine = bufferedReader.readLine();
            }

            bufferedReader.close();
//            textResult = stringBuilder.toString();

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Give Dict Entity Number:");
//

//            int entNumber = Integer.parseInt(System.console().readLine());

            System.out.println(dt.generateQuestion());
            System.out.println("To answer please type right number: ");

            int entNumber = Integer.parseInt(bufferedReader.readLine());

            while (!dt.checkAnswer(entNumber)) {
                System.out.println("You have chosen wrong answer! Please repeat");
                System.out.println("Your choice: ");
                entNumber = Integer.parseInt(bufferedReader.readLine());
            }
            System.out.println("You have chosen right answer!");
        } catch (
                IOException ex) {
        } finally {
//            System.out.println("Result:\n"+ textResult);
        }
    }
}
