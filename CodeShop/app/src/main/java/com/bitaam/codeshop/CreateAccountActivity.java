package com.bitaam.codeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class CreateAccountActivity extends AppCompatActivity {

    Button gotoLoginBtn,submitBtn;
    ProgressDialog progressDialog;
    TextView resultTextView;
    TextInputEditText emailEdt,passwordEdt,nameEdt,publicAddressEdt;
    String myUrl = "https://gethub-server.herokuapp.com/user/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        gotoLoginBtn = findViewById(R.id.goToLoginBtn);
        resultTextView = findViewById(R.id.resultTextView);
        submitBtn = findViewById(R.id.submitBtn);
        emailEdt = findViewById(R.id.email_input);
        passwordEdt = findViewById(R.id.password_input);
        nameEdt = findViewById(R.id.name_input);
        publicAddressEdt = findViewById(R.id.public_address_input);


        onClickActivities();

    }

    private void onClickActivities() {

        gotoLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MyAsyncTasks myAsyncTasks = new MyAsyncTasks();
//                myAsyncTasks.execute();
                String email = emailEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                String name = nameEdt.getText().toString();
                String publicAddress = publicAddressEdt.getText().toString();
                JSONObject postData = new JSONObject();
                try {
                    postData.put("email", "email@email.com");
                    postData.put("password", "password");
                    if (email.isEmpty() || password.isEmpty() || name.isEmpty() || publicAddress.isEmpty()){
                        Toast.makeText(getApplicationContext(), "No field can be empty", Toast.LENGTH_SHORT).show();
                    }else if((!email.isEmpty()) && (!password.isEmpty()) && (!name.isEmpty()) && (!publicAddress.isEmpty())){
                        new MyAsyncTasks().execute(email, password,name,publicAddress);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public class MyAsyncTasks extends AsyncTask<String, String, String> {

        String data="No Response";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

//            progressDialog = new ProgressDialog(getApplicationContext());
//            progressDialog.setMessage("Please wait fetching account");
//            progressDialog.setCancelable(false);
//            progressDialog.show();

        }

        @Override
        protected String doInBackground(String... params) {

            try {
                URL url = new URL("https://gethub-server.herokuapp.com/user/register");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setRequestProperty("Accept", "application/json");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();

                JSONObject jsonObject=new JSONObject();
                jsonObject.put("email",params[0]);
                jsonObject.put("password",params[1]);
                jsonObject.put("name",params[2]);
                jsonObject.put("public_address",params[3]);


                DataOutputStream outputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                outputStream.write(jsonObject.toString().getBytes("UTF-8"));

                int code = httpURLConnection.getResponseCode();
                if (code == 200) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                    StringBuffer stringBuffer = new StringBuffer();
                    String line;

                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuffer.append(line);
                    }
                    JSONObject object =  new JSONObject(stringBuffer.toString());
                    //   array = new JSONArray(stringBuffer.toString());
                    data = stringBuffer.toString();
                    //data = object.getString("token");

                }

            } catch (Exception e) {

                e.printStackTrace();
            }
            return data;

        }

        @Override
        protected void onPostExecute(String s) {

            //progressDialog.dismiss();
            resultTextView.setText(s);

            if (s.equals("No Response")){
                Toast.makeText(CreateAccountActivity.this, "Try again ! Something went wrong", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Login with email and password used to create account", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }

//            try {
//
//                JSONObject jsonObject = new JSONObject(s);
//
//                JSONArray jsonArray1 = jsonObject.getJSONArray("users");
//
//                JSONObject jsonObject1 =jsonArray1.getJSONObject(0);
//                String id = jsonObject1.getString("id");
//                String name = jsonObject1.getString("name");
//                String my_users = "User ID: "+id+"\n"+"Name: "+name;
//
//                //Show the Textview after fetching data
//                resultTextView.setVisibility(View.VISIBLE);
//
//                //Display data with the Textview
//                resultTextView.setText(my_users);
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }

        }

    }


}