import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    static Path sourcePath = Path.of(".\\src\\source\\source.txt");
    static Path destinationPath = Path.of(".\\src\\source\\destination.txt");

    public static void main(String[] args) {
        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();
        Cryptanalyser cryptanalyser = new Cryptanalyser();

        encryption.encrypt(3);



    }
}