package com.example.fetchvalue.Retrofit;

import com.example.fetchvalue.Model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetEmployeeDataService {
   /* @GET("retrofit-demo.php")
    Call<EmployeeList> getEmployeeData(@Query("company_no") int companyNo);*/

    @GET("users")
    Call<List<Employee>>getEmployeeData();
}
