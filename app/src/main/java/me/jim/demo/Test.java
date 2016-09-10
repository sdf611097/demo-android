package me.jim.demo;

import android.util.Log;

import java.util.List;

import me.jim.demo.retrofit.Repo;
import me.jim.demo.retrofit.RetrofitTest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;

/**
 * Created by ChunTingLin on 2016/9/10.
 */

//This should be a singleton?
public class Test {

    final static String TAG = "TEST";

    public static void testRetrofit() {
        new RetrofitTest().exec("sdf611097")
                .subscribe(new Observer<List<Repo>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        log("why fail? " + e.getMessage(), e);
                    }

                    @Override
                    public void onNext(List<Repo> repos) {
                        for (Repo repo : repos) {
                            log(repo.getName());
                        }
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
