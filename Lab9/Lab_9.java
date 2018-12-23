import java.util.Scanner;
import java.io.*;

public class Lab_9 {
    public static void main(String[] args){
        try {
            FileInputStream byteStream = new FileInputStream("src/input.txt");
            FileOutputStream outStream = new FileOutputStream("src/output.txt");
            PrintWriter writer = new PrintWriter(outStream);

            Scanner scanner = new Scanner(byteStream);

            while (scanner.hasNextInt()) {
                int binaryValue = Integer.parseInt(scanner.next(), 2);
                char binaryChar = (char) binaryValue;

                writer.print(binaryChar);
                writer.flush();
            }

        }


        catch (IOException noFile){
            System.out.println("Error: file not found.");
        }

    }
}
