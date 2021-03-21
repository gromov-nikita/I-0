import javax.annotation.processing.FilerException;
import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
Exercise 10: (2) Modify Exercise 8 to take additional command-line arguments of words
to find in the file. Print all lines in which any of the words match.

Exercise 8: (1) Modify Exercise 7 so that the name of the file you read is provided as a
command-line argument.

Exercise 7: (2) Open a text file so that you can read the file one line at a time. Read each
line as a String and place that String object into a LinkedList. Print all of the lines in the
LinkedList in reverse order.
*/
public class Runner {
    public static LinkedList<String> reader(String[] args) throws IOException {
        File file = new File(args[0]);
        FileReader fileR = null;
        try{
            LinkedList<String> list = new LinkedList<>();
            fileR = new FileReader(file);
            String str;
            int n = 1;
            BufferedReader fileBR = new BufferedReader(fileR);
            while(fileBR.ready()) {
                str = fileBR.readLine();
                for(int i = 1; i < args.length; i++) {
                    if(str.equals(args[i])) {
                        list.add(n + ") " + str);
                        break;
                    }
                }
                n++;
            }
            return list;
        }
        catch (Exception e) {
            throw new IOException();
        }
        finally {
            fileR.close();
        }
    }
    public static void main(String[] args) throws IOException {
        try {
            LinkedList<String> list = reader(args);
            ListIterator<String> it = list.listIterator(list.size());
            while (it.hasPrevious()) {
                System.out.println(it.previous());
            }
        } catch (Exception e) {
            System.err.println("Exception: Enter file name");
        }


    }
}
