import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Encryption {
    private ArrayList<Character> sourceTextArray;
    private List<Character> alphabet;


    public Encryption() {
        sourceTextArray = new ArrayList<>();
        alphabet = new ArrayList<>();
        try (InputStream inputStream = Files.newInputStream(Main.sourcePath)) {
        int c;
        while ((c = inputStream.read()) != -1) {
            sourceTextArray.add((char) c);
            System.out.print((char)c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        System.out.println(sourceTextArray); // Just for testing
        alphabetFiller();
    }




    public void encrypt( int key){
         ArrayList<Character> destArray = new ArrayList<>();




    }
        public void alphabetFiller(){
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

//            System.out.println(alphabet.toString());
        }

}


