package ru.netology.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CreatorFile {
    private String nameDir;
    private File dir;
    public CreatorFile (String nameDir){
        this.nameDir = nameDir;
        dir = new File(this.nameDir);
    }


    public void CreateDir(){
        if (dir.mkdirs())
            System.out.println("Каталог создан");

    }

    public void deleteDir(){
        if (dir.delete())
            System.out.println("Каталог удален");
    }

    public void createFail(){
        try {
            if (dir.createNewFile())
                System.out.println("Файл был создан");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteFail(){
        deleteDir();
    }

    public void cities () throws FileNotFoundException {
        Scanner sc = new Scanner(dir);
        while (sc.hasNext()){
            System.out.println(sc.nextLine());
        }
    }

    public void listObjects(){
        if (dir.isDirectory()) {
            // получаем все вложенные объекты в каталоге
            for (File item : dir.listFiles()) {
                // проверим, является ли объект каталогом
                if (item.isDirectory()) {
                    System.out.println(item.getName() + " - каталог");
                } else {
                    System.out.println(item.getName() + " - файл");
                }
            }
        }
    }
//    public void listObjects(){
//        if (dir.isDirectory()) {
//            // получаем все вложенные объекты в каталоге
//            for (File item : dir.listFiles()) {
//                // проверим, является ли объект каталогом
//                if (item.isDirectory()) {
//                    System.out.println(item.getName() + " - каталог");
//                } else {
//                    System.out.println(item.getName() + " - файл");
//                }
//            }
//        }
//
//    }

}

