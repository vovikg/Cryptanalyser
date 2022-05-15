import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        Path sourcePath = Path.of("/Users/vladimirgluschivschi/Documents/JavaTasks/source.txt");
        Path destinationPath = Path.of("/Users/vladimirgluschivschi/Documents/JavaTasks/destination.txt");


        try(InputStream inputStream = Files.newInputStream(sourcePath);
        OutputStream outputStream = Files.newOutputStream(destinationPath))
        {

            int c;
            while((c=inputStream.read())!=-1){

                System.out.print((char)c);
                list.add((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


    }
}