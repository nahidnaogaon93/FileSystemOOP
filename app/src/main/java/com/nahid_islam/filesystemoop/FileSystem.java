package com.nahid_islam.filesystemoop;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Nahid_Islam on 3/10/2016.
 */
public class FileSystem {
    Context context;

    public FileSystem() {

    }


    private static final String FOLDER_NAME = "/MyFolder/";
    private static final String FILE_NAME = "Nahid.txt";

    public String CreateDirectory() {
        File root = Environment.getExternalStorageDirectory();

        File directory = new File(root.getAbsolutePath() + FOLDER_NAME + FILE_NAME);
        try {
            directory.createNewFile();

            directory.mkdir();

            return directory.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return "0";
    }


    public boolean writeTextToFile(String directory, String text) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("" + directory);

            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
            writer.write(text);
            writer.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public String readTextFromFile(String directory) {
        String data = "";

        try {
            FileInputStream fileInputStream = new FileInputStream(new File("" + directory));
            if (fileInputStream != null) {
                InputStreamReader reader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String dataToBeReceived = "";
                StringBuilder builder = new StringBuilder();
                while ((dataToBeReceived = bufferedReader.readLine()) != null) {
                    builder.append(dataToBeReceived);
                }
                fileInputStream.close();
                data = builder.toString();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
