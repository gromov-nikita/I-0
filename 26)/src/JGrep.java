import java.nio.file.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {
    public static void main(String[] args) throws Exception {
        if(args.length > 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile("\\.$");
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        Path path = null;
        path = Paths.get("src\\readme.txt");
        for(String line : Files.readAllLines(path)) {
            m.reset(line);
            while(m.find())
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());
        }
    }
}