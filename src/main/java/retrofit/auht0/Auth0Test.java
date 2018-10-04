package retrofit.auht0;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class Auth0Test {

    private static final String BASE_URL = "https://frithjofhoppe.auth0.com/";

    private static Retrofit.Builder builder
            = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static OkHttpClient.Builder httpClient
            = new OkHttpClient.Builder();

    public static <S> S createService(Class<S> serviceClass, final String token) {

        if ( token != null ) {
            httpClient.interceptors().clear();
            httpClient.addInterceptor( chain -> {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Authorization", String.format("Bearer %s", token))
                        .build();
                return chain.proceed(request);
            });
            builder.client(httpClient.build());
            retrofit = builder.build();
        }

        return retrofit.create(serviceClass);
    }

    public static void perform(){
        final String token = "<bearer token>";
        Auth0Users auth0Users = createService(Auth0Users.class, token);
        Call<Auth0User> call = auth0Users.getUser("github|26481823");

        try {
            Response<Auth0User> response = call.execute();
            Auth0User auth0User = response.body();
            System.out.println(auth0User.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
