import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Encryption {
    private ArrayList<Character> sourceTextArray;
    private ArrayList<Character> alphabet;
    private ArrayList<Character> destTextArray;
    private OutputStream outputStream;

    {
        try {
            outputStream = Files.newOutputStream(Main.destinationPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Encryption() {
        sourceTextArray = new ArrayList<>();
        alphabet = new ArrayList<>();
        destTextArray = new ArrayList<>();

        try (InputStream inputStream = Files.newInputStream(Main.sourcePath)) {
            int c;
            while ((c = inputStream.read()) != -1) {
                sourceTextArray.add((char) c);
//                System.out.print((char) c); // for testing
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        System.out.println(sourceTextArray); // Just for testing

        alphabetFiller();


    }


        public void encrypt(int key) {
        Character currentChar;
        int indexOfCurrentCharInAlphabet;
        int indexOfEncryptedChar;
        Character encryptedChar;


        for (int i = 0; i < sourceTextArray.size(); i++) {
            currentChar = sourceTextArray.get(i);
            indexOfCurrentCharInAlphabet = getIndexOfSymbolInAlphabet(currentChar);

            if (indexOfCurrentCharInAlphabet != -1) {
                indexOfEncryptedChar = (indexOfCurrentCharInAlphabet + key) % alphabet.size();
                encryptedChar = alphabet.get(indexOfEncryptedChar);
            } else {
                encryptedChar = currentChar;
            }
            sourceTextArray.add(i, encryptedChar);
            outputWriter(destTextArray, outputStream);
        }

    }

    public void decryption(int key) {

    }


    private void setSourceTextArrayFiller(){

    }

    private void outputWriter(ArrayList<Character> whatIWantToWrite, OutputStream outputStream){
        for (int i = 0; i < whatIWantToWrite.size(); i++){
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

    private int getIndexOfSymbolInAlphabet(Character symbol) {
        int indexInAlphabet = -1;
        for (int i = 0; i < alphabet.size(); i++) {
            if (alphabet.get(i).equals(symbol)) {
                indexInAlphabet = i;
                break;
            }
        }
        return indexInAlphabet;
    }

}


