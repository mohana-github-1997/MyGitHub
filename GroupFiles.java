package NityaSoft;

import java.io.*;
import java.text.*;
import java.util.*;

public class GroupFiles {
    //Please refer SampleOutputForFilesProgram.txt file for sample output

    private static String FOLDER_PATH="D:\\photos\\Diwali2K18";
    public static void main(String[] args) throws IOException {
        File dir = new File(FOLDER_PATH);
        File[] files = dir.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Map<Date, List<File>> mapFiles = new TreeMap<>();
        for (File file : files) {
            try {
                Date date = sdf.parse(sdf.format(new Date(file.lastModified())));
                List<File> group = mapFiles.get(date);
                if (group == null) {
                    group = new ArrayList<>(25);
                    mapFiles.put(date, group);
                }
                group.add(file);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        for (Date date : mapFiles.keySet()) {
            System.out.println(sdf.format(date));
            System.out.println("No.of files: "+mapFiles.get(date).size());
        }
        System.out.println("Total Count of files in directory:"+ files.length);
    }
}
