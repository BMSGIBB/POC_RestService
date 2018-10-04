package retrofit.auht0;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Auth0Users {
    @GET("/api/v2/users/{id}")
    Call<Auth0User> getUser(@Path("id") String id);
}
