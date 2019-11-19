package com.example.fetchvalue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.fetchvalue.Model.Employee;
import com.example.fetchvalue.Retrofit.GetEmployeeDataService;
import com.example.fetchvalue.Retrofit.RetrofitInstance;




import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
       //---->requimended first  //https://www.androidtutorialpoint.com/networking/retrofit-android-tutorial/
        //https://medium.com/@jacinth9/android-retrofit-2-0-tutorial-89de3c714c63
        //https://demonuts.com/retrofit-android-get-json/
        //https://www.androidhive.info/2016/05/android-working-with-retrofit-http-library/
        //https://www.journaldev.com/13639/retrofit-android-example-tutorial
        textView=findViewById( R.id.textview );
        Retrofit();
    }

    public void Retrofit(){
        Retrofit retrofit = RetrofitInstance.getRetrofitInstance();
        GetEmployeeDataService api = retrofit.create( GetEmployeeDataService.class );

       api.getEmployeeData().enqueue( new Callback<List<Employee>>() {
           @Override
           public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
               if(response.code() ==200){
                   Log.d( TAG, "onResponse: Sucessfull" );
               List<Employee> employees=response.body();
               for(int i=0;i<employees.size();i++){
                   if(i==0) {
                       textView.setText( "ID :" + employees.get( i ).getId()+" \n"+
                                         "LOGIN:"+employees.get( i ).getLogin()+"\n"+
                                         "TYPE:"+employees.get( i ).getType()+" \n"+
                                         "URL"+employees.get( i ).getUrl());
                   }
               }

               }
           }

           @Override
           public void onFailure(Call<List<Employee>> call, Throwable t) {
               Log.d( TAG, "onFailure: unsucessfull" );
           }
       } );

    }
}
