package ru.netology.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CreatorDatabase {
    File repo = new File("src//main//resources");

    public CreatorDatabase() throws FileNotFoundException {
        List<File> listFile = new LinkedList<>();
        TreeSet<String> myTreeSet = new TreeSet<>();
        Set<Character> abc = new TreeSet<>();
        HashMap<Set, String[]> map = new HashMap<>();

        if (repo.isDirectory()) {
            // получаем все вложенные объекты в каталоге
            for (File item : Objects.requireNonNull(repo.listFiles())) {
                // проверим, является ли объект файлом
                if (item.isFile()) {
                    System.out.println(item.getName() + " - файл");
//                    listFile.add(item.getName());
                    if (getFileExtension(item).equals("txt")) {
                        listFile.add(item);
                    }
                }
            }
        }

        for (File file : listFile) {
            String bufferS;
            System.out.println(file + " ");
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
//                System.out.println(sc.nextLine());
//                if (!set.add(sc.nextLine())) {
//                    System.out.println("!!!! " + sc.nextLine() + " !!!!");
//                }
                bufferS = sc.nextLine();
                myTreeSet.add(bufferS);
                abc.add(bufferS.charAt(0));

            }
//            System.out.println(myTreeSet);
//            abc.stream().forEach(S -> System.out.println(S));

        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".") + 1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }
}
