package com.example.sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dezlum.codelabs.getjson.GetJson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;


public class ViewInsertCar extends AppCompatActivity {

    ModelCar dataBase;
    TextView viewCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewinsertcar);

        viewCars = findViewById(R.id.editTextComSQL);

        //database
        dataBase = new ModelCar(this);
        dataBase.createDataBase();

        try {
            JsonObject jsonObject = new GetJson().AsJSONObject("https://api.myjson.com/bins/pwzfw");
            JsonElement cars =  jsonObject.get("cars");
            JsonElement message =  jsonObject.get("message");
            System.out.println(cars);
            System.out.println(message);

            //Toast.makeText(this,status.toString() , Toast.LENGTH_SHORT).show();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void jsonParse(View v){
        System.out.println("oi");

    }

    public void insertCar(View v) {
        EditText nameCar = findViewById(R.id.nameCar);
        EditText boardCar = findViewById(R.id.boardCar);
        EditText yearCar = findViewById(R.id.yearCar);

        if (nameCar.getText().length() != 0 && boardCar.getText().length() != 0 && yearCar.getText().length() != 0) {
            dataBase.insertCar(nameCar.getText(), boardCar.getText(), yearCar.getText());
            nameCar.setText("");
            boardCar.setText("");
            yearCar.setText("");
        } else {
            Toast.makeText(this, "Preencha todos os cammpos!", Toast.LENGTH_SHORT).show();
        }
    }

    public void alterarComSQLClick(View v) {
        dataBase.updateCar(1, "Celtinha", "aaa4321", "2002");
    }

    public void excluirComSQLClick(View v) {
        dataBase.deleteCar(1);
    }

    public void buscarComSQLClick(View v) {
        String returnDb = dataBase.selectCar("Celta");

        viewCars.setText(returnDb);
    }


    RequestQueue queue = null;
    public static final String TAG = "MinhaTag";

    public void requestPOST(final View view) {

        //cria uma fila de requisições
        queue = Volley.newRequestQueue(this);

        String url = "http://172.16.0.9:80";
               url = "http://172.16.0.77:3333";
        //monta a requisição
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String resposta = response.substring(0);
                        //testa o valor da resposta obtiida do servidor
                        viewCars.setText(resposta);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewInsertCar.this, "Erro:" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("login", "admin");
                //params.put("senha", senha);
                return params;
            }
        };
        //da uma tag para a requisição
        stringRequest.setTag(TAG);
        RetryPolicy policy = new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        //adiciono a requisição na fila de requisições para que ela seja dispachada
        queue.add(stringRequest);
    }

    public void requestGET(View v){

        RequestQueue queue = Volley.newRequestQueue(this);

        String url ="http://172.16.0.77:80";
               url = "http://172.16.0.77:3333";
               //url = "https://api.myjson.com/bins/etcv8";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        viewCars.setText(response);
                        //String respondeSplit[] = response.split(",");
                        //viewCars.setText("Olá "+respondeSplit[0]+", sua idade é "+respondeSplit[1]);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
                viewCars.setText("That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    @Override
    protected void onStop () {
        super.onStop();
        if (queue != null) {
            //cancela todas as requisições com a tag "MinhaTag"
            queue.cancelAll(TAG);
        }
    }






}