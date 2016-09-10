package me.jim.demo;

import android.util.Log;

import java.util.List;

import me.jim.demo.retrofit.Repo;
import me.jim.demo.retrofit.RetrofitTest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ChunTingLin on 2016/9/10.
 */

//This should be a singleton?
public class Test {

    final static String TAG = "TEST";

    public static void testRetrofit(){
        new RetrofitTest().exec("sdf611097", new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                log("wa A repo");
                for (Repo repo : response.body()) {
                    log(repo.getName());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                log("why fail? " + t.getMessage(), t);
            }
        });
    }


    private static void log(String msg) {
        log(msg, null);
    }

    private static void log(String msg, Throwable t) {
        Log.e(TAG, msg, t);
    }
}
