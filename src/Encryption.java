import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Encryption {
    private ArrayList<Character> sourceTextArray= new ArrayList<>();
    private ArrayList<Character> alphabet = new ArrayList<>();
    private ArrayList<Character> destTextArray = new ArrayList<>();
    private ArrayList<Character> decryptedTextArray = new ArrayList<>();



    public Encryption() {
//        sourceTextArray = new ArrayList<>();
//        alphabet = new ArrayList<>();
//        destTextArray = new ArrayList<>();
//        decryptedTextArray = new ArrayList<>();


//        try (BufferedReader inputStream = Files.newBufferedReader(Main.sourcePath)) {
//            int c;
//            while ((c = inputStream.read()) != -1) {
//                sourceTextArray.add((char) c);
////                System.out.print((char) c); // for testing
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        System.out.println(sourceTextArray); // Just for testing

        alphabetFiller();


    }

    private void readFromFile(String file, List<Character> list){
        try (BufferedReader inputStream = Files.newBufferedReader(Path.of(file))) {
            String line = "";
            while ((line = inputStream.readLine()) != null){
                for (char c: line.toCharArray()) {
                    list.add(c);
                }
            }
//            System.out.println(sourceTextArray.toString());

//            int c;
//            while ((c = inputStream.read()) != -1) {
//                sourceTextArray.add((char) c);
////                System.out.print((char) c); // for testing
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void encrypt(String sourceFile,String destinationFile, int key) {
        readFromFile(sourceFile, sourceTextArray);
        Character currentChar;
        int indexOfCurrentCharInAlphabet;
        int indexOfEncryptedChar;
        Character encryptedChar;
        for (Character c: sourceTextArray) {
//            currentChar = sourceTextArray.get(i);
//            indexOfCurrentCharInAlphabet = getIndexOfSymbolInAlphabet(currentChar);
            indexOfCurrentCharInAlphabet = alphabet.indexOf(c);

            if (indexOfCurrentCharInAlphabet != -1) {
                indexOfEncryptedChar = (indexOfCurrentCharInAlphabet + key) % alphabet.size();
                encryptedChar = alphabet.get(indexOfEncryptedChar);
            } else {
                encryptedChar = c;
            }
            destTextArray.add(encryptedChar);

        }
        writeToFile(destinationFile, destTextArray);
    }
        private void writeToFile(String file, List<Character> list){
        try(BufferedWriter writer = Files.newBufferedWriter(Path.of(file))){
            for (Character c: list) {
                writer.append(c);
            }
        } catch (IOException e) {}

        }
    public void decryption(String sourceFile, String destinationFile, int key) {
        readFromFile(sourceFile, destTextArray);
        Character currentChar;
        int indexOfCurrentCharInAlphabet;
        int indexOfEncryptedChar;
        Character encryptedChar;
        for (Character c: destTextArray) {
//            currentChar = sourceTextArray.get(i);
//            indexOfCurrentCharInAlphabet = getIndexOfSymbolInAlphabet(currentChar);
            indexOfCurrentCharInAlphabet = alphabet.indexOf(c);

            if (indexOfCurrentCharInAlphabet != -1) {
                indexOfEncryptedChar = (indexOfCurrentCharInAlphabet - key) % alphabet.size();
                encryptedChar = alphabet.get(indexOfEncryptedChar);
            } else {
                encryptedChar = c;
            }
            decryptedTextArray.add(encryptedChar);

        }
        writeToFile(destinationFile, decryptedTextArray);
    }


    private void setSourceTextArrayFiller() {

    }

    private void outputWriter(ArrayList<Character> whatIWantToWrite, OutputStream outputStream) {
        for (int i = 0; i < whatIWantToWrite.size(); i++) {
            try {
                outputStream.write(destTextArray.get(i));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private void alphabetFiller() {
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');
        alphabet.add('d');
        alphabet.add('e');
        alphabet.add('f');
        alphabet.add('g');
        alphabet.add('h');
        alphabet.add('i');
        alphabet.add('j');
        alphabet.add('k');
        alphabet.add('l');
        alphabet.add('m');
        alphabet.add('n');
        alphabet.add('o');
        alphabet.add('p');
        alphabet.add('q');
        alphabet.add('r');
        alphabet.add('s');
        alphabet.add('t');
        alphabet.add('u');
        alphabet.add('v');
        alphabet.add('w');
        alphabet.add('x');
        alphabet.add('y');
        alphabet.add('z');
        alphabet.add(' ');
        alphabet.add('.');
        alphabet.add(',');
        alphabet.add('"');
        alphabet.add(':');
        alphabet.add('-');
        alphabet.add('!');
        alphabet.add('?');


    }

//    private int getIndexOfSymbolInAlphabet(Character symbol) {
//        int indexInAlphabet = -1;
//        for (int i = 0; i < alphabet.size(); i++) {
//            if (alphabet.get(i).equals(symbol)) {
//                indexInAlphabet = i;
//                break;
//            }
//        }
//        return indexInAlphabet;
//    }

}


