import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;

public class Encryption {
    ArrayList<Character> sourceTextArray;

    public Encryption() {
        sourceTextArray = new ArrayList<>();

        try (InputStream inputStream = Files.newInputStream(Main.sourcePath)) {
        int c;
        while ((c = inputStream.read()) != -1) {


            sourceTextArray.add((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        System.out.println(sourceTextArray); // Just for testing
    }




    public ArrayList encrypt(ArrayList inputFile, ArrayList output, int key){
        return null;
    }
}


