import java.util.*;
import java.io.*;
public class DirList {
    public static void filesFind(String[] args, File file, List<String> list) {
        File[] files = file.listFiles();
        if(args.length == 0) {
           for(File f : files) {
               list.add(f.getName());
               if(f.isDirectory()) {
                   filesFind(args, f, list);
               }
           }
        }
        else {
            //"^\\D+.java"
            DirFilter dir = new DirFilter(args[0]);
            for(File f : files) {
                if(dir.accept(file,f.getName())) {
                    list.add(f.getName());
                }
                if(f.isDirectory()) {
                    filesFind(args, f, list);
                }
            }
        }
    }
    public static void main(String[] args) {
        File path = new File(".");
        List<String> list = new LinkedList<String>();
        filesFind(args,path,list);
        //Для проверки сортировки я создал папки в ".idea" (z) и в "1)" (1 a aa ab)
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String s : list) {
            System.out.println(s);
        }
    }
}

