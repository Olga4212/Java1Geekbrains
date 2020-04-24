package lesson6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        writeFile("file1.txt", "Не выходи из комнаты, не совершай ошибку.\n");
        writeFile("file2.txt", "Зачем тебе Солнце, если ты куришь Шипку?\n");
        writeFile("file3.txt", "За дверью бессмысленно всё, особенно — возглас счастья.\n");

        concatenateFiles(new String[]{"file1.txt", "file2.txt", "file3.txt"}, "output.txt");
    }

    private static void concatenateFiles(String[] files, String output) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i<files.length; i++){
            try {
                FileInputStream input = new FileInputStream(files[i]);
                result.append( new String(input.readAllBytes()));
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        writeFile(output, result.toString());
    }

    public static void writeFile(String fileName, String text) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            file.write(text.getBytes());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}


