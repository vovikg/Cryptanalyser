import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    static Path sourcePath = Path.of("/Users/vladimirgluschivschi/Documents/JavaTasks/source.txt");;
    static Path destinationPath = Path.of("/Users/vladimirgluschivschi/Documents/JavaTasks/destination.txt");;

    public static void main(String[] args) {
        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();
        Cryptanalyser cryptanalyser = new Cryptanalyser();

        encryption.encrypt(3);



    }
}