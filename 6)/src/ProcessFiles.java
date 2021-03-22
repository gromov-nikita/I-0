import java.io.File;
import java.util.Calendar.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }
    private Strategy strategy;
    private Calendar date = new GregorianCalendar();
    public ProcessFiles(Strategy strategy, int day) {
        this.strategy = strategy;
        date.set(Calendar.DAY_OF_MONTH,day);
    }
    public void start(String[] args) {
        try {
            processDirectoryTree(new File("."));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void processDirectoryTree(File root) throws IOException {
        for(File file : Directory.walk(root.getAbsolutePath(), "^.+")) {
            if(file.lastModified() > date.getTimeInMillis()) {
                strategy.process(file.getCanonicalFile());
            }
        }
    }
    // Demonstration of how to use it:
    public static void main(String[] args) {
        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
                System.out.println(file);
            }
        },21).start(args);
    }
}
