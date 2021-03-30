import java.io.*;
public class BufferedInputFile {
    // Throw exceptions to console:
    public static String read(String filename) throws IOException {
        // Reading input by lines:
        BufferedReader in = null;
        StringBuilder sb = null;
        try {
            in = new BufferedReader(
                    new FileReader(filename));
            String s;
            sb = new StringBuilder();
            while ((s = in.readLine()) != null)
                sb.append(s + "\n");
        }
        catch(FileNotFoundException b) {
            throw new FileNotFoundException();
        }
        finally {
            in.close();
        }
        return sb.toString();
    }
    public static void main(String[] args)
            throws IOException {
        System.out.print(read("BufferedInputFile.java"));
    }
}