import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BasicFileOutput {
    public static void copyFBuff(String inPath, String outPath) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new StringReader(BufferedInputFile.read(inPath)));
            out = new PrintWriter(new BufferedWriter(new FileWriter(outPath)));
            String s;
            while ((s = in.readLine()) != null)
                out.println(s);
        }
        finally {
            in.close();
            out.close();
        }
    }
    public static void copyF(String inPath, String outPath) throws IOException {
        BasicFileOutput.writeF(outPath,BasicFileOutput.readF(inPath));
    }
    public static List readF(String inPath) throws IOException {
        FileReader in = null;
        List<Character> list = new ArrayList<Character>();
        try {
            in = new FileReader(inPath);
            int save = in.read();
            while (save != -1) {
                list.add((char) save);
                save = in.read();
            }
        }
        catch(Exception ex) {
            System.err.println("BasicFileOutput.readF()");
        }
        finally {
            in.close();
        }
        return list;
    }
    public static void writeF(String outPath, List<Character> list) throws IOException {
        FileWriter out = null;
        try {
            out = new FileWriter(outPath);
            for (char c : list) {
                out.write(c);
            }
        }
        catch (Exception ex) {
            System.err.println("BasicFileOutput.writeF()");
        }
        finally {
            out.close();
        }
    }
    public static void main(String[] args) throws IOException {
        long timeAfter;
        int timeBuffered;
        long timeBefore = System.nanoTime();
        BasicFileOutput.copyFBuff("src\\BasicFileOutput.java", "src\\writemeBuffered.txt");
        timeAfter = System.nanoTime();
        timeBuffered = (int)(timeAfter - timeBefore);
        timeBefore = System.nanoTime();
        BasicFileOutput.copyF("src\\BasicFileOutput.java", "src\\writeme.txt");
        timeAfter = System.nanoTime();
        int time = (int)(timeAfter - timeBefore);
        System.out.println("timeBuffered: " + timeBuffered);
        System.out.println("time: " + time);
        System.out.println("timeBuffer - time = " + (timeBuffered - time));
    }
}