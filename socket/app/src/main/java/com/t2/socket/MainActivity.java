package com.t2.socket;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    private static Socket s;
    private static BufferedReader br;
    private static PrintWriter printWriter;
    String message = "";
    private static String ip = "192.168.1.102";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.editText);

    }

    public void  send_text(View v){
        message = e1.getText().toString();

        myTask mt = new myTask();
        mt.execute();

        Toast.makeText(getApplicationContext(), "Data Send",Toast.LENGTH_LONG).show();
    }

    class myTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                s = new Socket(ip,1111);
                printWriter = new PrintWriter(s.getOutputStream());
                printWriter.write(message);
                printWriter.flush();
                printWriter.close();
                s.close();





            } catch (IOException e){
                e.printStackTrace();
            }

            return null;
        }


    }

}