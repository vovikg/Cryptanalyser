import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Encryption {
    private ArrayList<Character> sourceTextArray = new ArrayList<>();
    private ArrayList<Character> alphabet = new ArrayList<>();
    private ArrayList<Character> destTextArray = new ArrayList<>();
    private ArrayList<Character> decryptedTextArray = new ArrayList<>();


    public Encryption() {

        alphabetFiller();


    }

    private void readFromFile(String file, List<Character> list) {
        try (BufferedReader inputStream = Files.newBufferedReader(Path.of(file))) {
            String line = "";
            while ((line = inputStream.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    list.add(c);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void encrypt(String sourceFile, String destinationFile, int key) {
        readFromFile(sourceFile, sourceTextArray);
        Character currentChar;
        int indexOfCurrentCharInAlphabet;
        int indexOfEncryptedChar;
        Character encryptedChar;
        for (Character c : sourceTextArray) {

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

    private void writeToFile(String file, List<Character> list) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(file))) {
            for (Character c : list) {
                writer.append(c);
            }
        } catch (IOException e) {
        }

    }

    public void decryption(String sourceFile, String destinationFile, int key) {
        readFromFile(sourceFile, destTextArray);

        int indexOfCurrentCharInAlphabet;
        int indexOfEncryptedChar;
        Character encryptedChar;
        for (Character c : destTextArray) {

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

}


