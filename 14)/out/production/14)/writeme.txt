import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BasicFileOutput {
    static String file = "src\\writemeBuffered.txt";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("src\\BasicFileOutput.java")));
        PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null )
            out1.println(lineCount++ + ": " + s);
        long timeAfter;
        int timeBuffered;
        long timeBefore = System.nanoTime();
        out1.println(BufferedInputFile.read(file));
        timeAfter = System.nanoTime();
        timeBuffered = (int)(timeAfter - timeBefore);
        out1.close();
        FileWriter out2 = new FileWriter("src\\writeme.txt");
        FileReader in2 = new FileReader("src\\BasicFileOutput.java");
        List<Character> list = new ArrayList<Character>();
        int save = in2.read();
        while(save != -1) {
            list.add((char)save);
            save = in2.read();
        }
        timeBefore = System.nanoTime();
        for(char c : list) {
            out2.write(c);
        }
        timeAfter = System.nanoTime();
        int time = (int)(timeAfter - timeBefore);
        System.out.println("timeBuffered: " + timeBuffered);
        System.out.println("time: " + time);
        System.out.println("timeBuffer - time = " + (timeBuffered - time));
        in2.close();
        out2.close();
        System.nanoTime();
        // Show the stored file:
        //System.out.println(BufferedInputFile.read(file));
    }
}