package retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface UserService {

    @GET("/users")
    Call<List<User>> getUsers(@Query("per_page") int per_page, @Query("page") int page);

    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
}
