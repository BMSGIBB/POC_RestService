package retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class RetroFitExample {
    public static void perform(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        UserService userService = retrofit.create(UserService.class);
        Call<User> call = userService.getUser("frithjofhoppe");

        call.enqueue(new Callback<User>() {
            public void onResponse(Call<User> call, Response<User> response) {
                System.out.println(response.body().toString());
            }

            public void onFailure(Call<User> call, Throwable throwable) {

            }
        });

        System.out.println("passed");

    }
}
