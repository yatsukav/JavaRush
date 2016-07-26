package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        FileOutputStream fos = new FileOutputStream(reader.readLine());
        while (fis.available() > 0) {
            byte[] buffer = new byte[fis.available()];
            int count = fis.read(buffer);
            for (int i = 0; i < buffer.length / 2; i++) {
                byte buf = buffer[i];
                buffer[i] = buffer[buffer.length - i - 1];
                buffer[buffer.length - i - 1] = buf;
            }
            fos.write(buffer, 0, count);
        }
        reader.close();
        fis.close();
        fos.close();
    }
}
