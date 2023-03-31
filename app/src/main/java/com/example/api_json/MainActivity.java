package com.example.api_json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView txt, txt2, txt3;
    private RequestQueue mRequestQueue;
    private JsonObjectRequest request;
    private String url = "https://run.mocky.io/v3/85cf9aaf-aa4f-41bf-b10c-308f032f7ccc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView1);
        txt3 = findViewById(R.id.textView2);

        getData();
    }

    private void getData() {
        //jo bhi object banayenge wo requestqueue me aayega
        RequestQueue mRequestQueue= Volley.newRequestQueue(this);

        request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray jad = response.getJSONArray("users");
                    JSONObject obj = jad.getJSONObject(0);

                    txt.setText(obj.getString("website"));
                    txt2.setText(obj.getString("founder"));
                    txt3.setText(obj.getString("country"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mRequestQueue.add(request);
    }
}



//to manipulate the data.



//public
//partner
//private
//composite