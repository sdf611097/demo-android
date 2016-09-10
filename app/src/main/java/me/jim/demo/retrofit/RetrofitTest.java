package me.jim.demo.retrofit;

import java.util.List;

import me.jim.demo.retrofit.Repo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ChunTingLin on 2016/9/10.
 */
public class RetrofitTest {

    private GitHubService service;
    public RetrofitTest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(GitHubService.class);
    }
    public interface GitHubService {
        @GET("users/{user}/repos")
        Call<List<Repo>> listRepos(@Path("user") String user);
    }

    public void exec(String user, Callback<List<Repo>> callback){
        Call<List<Repo>> call = service.listRepos(user);
        call.enqueue(callback);
    }

}
