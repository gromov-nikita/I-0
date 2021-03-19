/*
Exercise 6: (5) Use ProcessFiles to find all the Java source-code files in a particular
directory subtree that have been modified after a particular date.
 */

import java.io.File;

public class Runner {
    public static void main(String[] args) {
        File file = new File("\\test");
        System.out.println(file.getAbsolutePath());

    }
}
