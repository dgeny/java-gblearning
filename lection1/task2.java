/*
 *  Даны два файла, в каждом из которых находится запись
 *  многочлена. Сформировать файл содержащий сумму
 *  многочленов.
 */
package lection1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task2 {
    public static void main(String[] args) {
        String f1 = "file1.txt", f2= "file2.txt";
        try {
            BufferedReader fd1 = new BufferedReader()
            String t1 = fd1.lines().toString();
            fd1.close();
            System.out.println(t1);
        } catch (IOException e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
    }
}
