package com.example.mdarifur.demoretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.Callback;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    String url = "https://api.github.com";
    TextView company;
    TextView blog;
    TextView htmlurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        company = (TextView) findViewById(R.id.txt_comp);
        blog = (TextView) findViewById(R.id.txt_blog);
        htmlurl = (TextView) findViewById(R.id.txt_hurl);

        RestAdapter radapter=new RestAdapter.Builder().setEndpoint(url).build();

        MInterface restInt=radapter.create(MInterface.class);
        restInt.getUser(new Callback<Pojo>() {
            @Override
            public void success(Pojo model, Response response) {
                company.setText("Company Name :"+model.getCompany());
                blog.setText("Website :"+model.getBlog());
                htmlurl.setText("Git URL :"+model.getHtmlUrl());

            }

            @Override
            public void failure(RetrofitError error) {
                String err = error.getMessage();
            }
        });

    }
}
