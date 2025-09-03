package exceptionhandling;
import java.io.*;

public class ExceptionChaining {


    public static void readFile(String fileName) throws Exception {
        try {

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            br.close();
        } catch (IOException e) {
            throw new Exception("Error occurred while processing the file.", e);
        }
    }

    public static void main(String[] args) {
        try {

            readFile("non_existing_file.txt");
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e);
            System.out.println("Cause of Exception: " + e.getCause());
        }
    }
}
