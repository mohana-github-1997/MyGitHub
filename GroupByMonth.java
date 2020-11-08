package NityaSoft;

import java.io.*;
import java.text.*;
import java.util.*;

public class GroupByMonth {

    private static String FOLDER_PATH="D:\\photos\\Diwali2K18";
    public static void main(String[] args) throws IOException {
        File dir = new File(FOLDER_PATH);
        showFiles(dir);

    }
    private static void showFiles(File dir) {
        File[] files = dir.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Map<Date, List<File>> mapFiles = new TreeMap<>();
        Map<List<Date>, List<File>> mapFiles1 = new TreeMap<>();
        //Date date = sdf.parse(sdf.format(new Date(file.lastModified())));
        //List<File> group = mapFiles.get(date);

        //List l1=new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                showFiles(file);
            } else {
                try {
                    Date date = sdf.parse(sdf.format(new Date(file.lastModified())));
                    List<File> group = mapFiles.get(date);
                    List d1 = mapFiles.get(sdf.format(date));
                    if (group == null) {
                        group = new ArrayList<>(25);
                        mapFiles.put(date, group);
                    }
                   /* if (d1 == null) {
                        d1 = new ArrayList<>(25);
                        mapFiles1.put(d1, group);

                        //mapFiles1.put(d1,group);
                    }
                    else if(d1.equals(mapFiles.get(date)))
                    {
                       mapFiles1.put(d1, group);
                    }*/

                    //mapFiles.put(date, group);
                   /*else if(mapFiles.get(date).equals(file.lastModified()))
                    {
                        mapFiles.put(date, group);
                    }*/
                    group.add(file);
                    d1.add(file);

                    //System.out.println(sdf.format(date));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

            }

        }

        for (Date date : mapFiles.keySet()) {

            System.out.println(sdf.format(date));
            System.out.println("No.of files: " + mapFiles.get(date).size());

        }
            /*for(List d1: mapFiles1.keySet())
            {
                System.out.println(sdf.format(d1));
                System.out.println("No.of files: " + mapFiles1.get(d1).size());

            }*/

        System.out.println("Total Count of files in directory:" + files.length);
    }


}
