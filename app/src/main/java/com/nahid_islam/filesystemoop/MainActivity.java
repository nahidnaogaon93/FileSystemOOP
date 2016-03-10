package com.nahid_islam.filesystemoop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputYourTextEt;
    TextView showYourTextFileData;
    FileSystem fileSystem;

    String directory;
    boolean isdirectoryCreated;
    boolean isWriteComplete;
    String retrieveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputYourTextEt = (EditText) findViewById(R.id.inputEditText);
        showYourTextFileData = (TextView) findViewById(R.id.textFile);

        fileSystem = new FileSystem();
        directory = fileSystem.CreateDirectory();

        if (directory.length() != 0) {
            isdirectoryCreated = true;
            Toast.makeText(getApplicationContext(), "Path created", Toast.LENGTH_LONG).show();
        } else {
            isdirectoryCreated = false;
            Toast.makeText(getApplicationContext(), "Path not created", Toast.LENGTH_LONG).show();

        }


    }


    public void btnWriteToFile(View view) {
        String textTobeWrite = inputYourTextEt.getText().toString();
        if (isdirectoryCreated) {
            isWriteComplete = fileSystem.writeTextToFile(directory, textTobeWrite);
            inputYourTextEt.setText("");
            if (isWriteComplete) {
                Toast.makeText(getApplicationContext(), "Message saved successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Message not saved successfully", Toast.LENGTH_SHORT).show();

            }
        } else {
            Toast.makeText(getApplicationContext(), "Path not found", Toast.LENGTH_SHORT).show();

        }


    }

    public void btnReadFromFile(View view) {


        if (isdirectoryCreated) {
            retrieveData = fileSystem.readTextFromFile(directory);
        } else {
            Toast.makeText(getApplicationContext(), "dir not found", Toast.LENGTH_SHORT).show();

        }
        showYourTextFileData.setText(retrieveData);
    }


}



