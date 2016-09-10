package me.jim.demo.retrofit;

import java.util.List;

import me.jim.demo.retrofit.Repo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ChunTingLin on 2016/9/10.
 */
public class RetrofitTest {

    private GitHubService service;

    public RetrofitTest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(GitHubService.class);
    }

    public interface GitHubService {
        @GET("users/{user}/repos")
        Observable<List<Repo>> listRepos(@Path("user") String user);
    }

    public Observable<List<Repo>> exec(String user) {
        return service.listRepos(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
