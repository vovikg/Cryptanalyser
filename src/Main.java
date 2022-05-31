import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
//    static Path sourcePath = Path.of("files/source.txt");
//    static Path destinationPath = Path.of("files/source.txt");

    public static void main(String[] args) {
        Encryption encryption = new Encryption();
        encryption.encrypt("files/source.txt", "files/destination.txt",3);
        encryption.decryption("files/destination.txt", "files/decryptedFile.txt", 3);



//        Decryption decryption = new Decryption();
//        Cryptanalyser cryptanalyser = new Cryptanalyser();





    }
}