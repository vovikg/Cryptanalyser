import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Encryption {
    private ArrayList<Character> sourceTextArray;
    private char alphabetArray[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'x',
            '1','2','3','4','5','6','7','8','9','0','!','@','£','$','%','(',')','?','\\','.',','};

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




    public void encrypt( int key){
        ArrayList<Character> destArray = new ArrayList<>();



        for(int i =0; i <= sourceTextArray.size(); i ++){

            destArray.add(i, sourceTextArray.get(i+key));



            }
        System.out.println("DestArray = :"+ destArray);

    }
}


