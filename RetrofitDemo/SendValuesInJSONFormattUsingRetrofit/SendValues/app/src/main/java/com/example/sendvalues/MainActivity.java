package com.example.sendvalues;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sendvalues.ModelClass.Model;
import com.example.sendvalues.Retrofit.APIService;
import com.example.sendvalues.Retrofit.BaseApplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText Title,Body;
    TextView resources;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        //https://www.youtube.com/watch?v=lhhIZ92gFLA
        //https://code.tutsplus.com/tutorials/sending-data-with-retrofit-2-http-client-for-android--cms-27845
        //https://www.dev2qa.com/retrofit-android-get-post-example/
        //http://websystique.com/java/json/gson-json-annotations-example/  <---theory propose.
        Title=findViewById( R.id.et_title );
        Body=findViewById( R.id.et_body );
        resources=findViewById( R.id.tv_response );

    }

    public void submit(View view) {
       Log.d( TAG, "submit152: "+view );
      String FTitle = Title.getText().toString();
      String FBody=Body.getText().toString();
/*//This one way to declare
Retrofit retrofit=new Retrofit.Builder()
        .baseUrl( "http://httpbin.org/" )
        .addConverterFactory( GsonConverterFactory.create())
        .build();
APIService apiService=retrofit.create( APIService.class );*/

//this another way to declare.
        Retrofit retrofit = BaseApplication.getRetrofitInstance();
        APIService api = retrofit.create( APIService.class );
        Model model=new Model(FTitle,FBody );
       //Call<Model> call=api.savePost( model );
       // Log.d( TAG, "url: "+call.request().url() );
/*call.enqueue( new Callback<Model>() {
    @Override
    public void onResponse(Call<Model> call, Response<Model> response) {
        Log.d( TAG, "onResponse: successfull" );
        resources.setText( response.body().getJson().getTitle()+"\n"+
                response.body().getJson().getBody());
    }

    @Override
    public void onFailure(Call<Model> call, Throwable t) {
        Log.d( TAG, "onFailure: unsucessful" );
    }
} );*/

api.savePost( model ).enqueue( new Callback<Model>() {
    @Override
    public void onResponse(Call<Model> call, Response<Model> response) {
        Log.d( TAG, "onResponse: successfull" );
       resources.setText( response.body().getJson().getTitle()+"\n"+
                          response.body().getJson().getBody());
    }

    @Override
    public void onFailure(Call<Model> call, Throwable t) {
        Log.d( TAG, "onFailure: unsucessful" );

    }
} );
        }


}
