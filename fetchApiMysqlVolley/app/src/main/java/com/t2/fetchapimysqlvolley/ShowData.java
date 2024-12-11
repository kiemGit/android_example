package com.t2.fetchapimysqlvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ShowData extends AppCompatActivity {

    ListView listView;
    MyAdapter myAdapter;
    DataClass dataClass;

    //String url = "http://192.168.1.102/androidDb/get.php";
    String url = "http://192.168.0.39:8005/api/readData";
    public static ArrayList<DataClass> dataClassArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        listView = findViewById(R.id.listview);
        myAdapter = new MyAdapter(this,dataClassArrayList);
        listView.setAdapter(myAdapter);

        getData();
        

    }

    private void getData() {
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                dataClassArrayList.clear();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if (success.equals("1")){
                        for (int i = 0;i<jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);

                            //String id = object.getString("id");
                            String id = object.getString("id");
                            String name = object.getString("name");
                            String age = object.getString("age");
                            String gender = object.getString("gender");

                            dataClass = new DataClass(id,name,age,gender);
                            dataClassArrayList.add(dataClass);
                            myAdapter.notifyDataSetChanged();

                        }
                    }

                }catch (Exception e){

                }

                // Toast.makeText(ShowData.this,response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ShowData.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


        RequestQueue requestQueue= Volley.newRequestQueue(ShowData.this);
        requestQueue.add(request);
    }
}