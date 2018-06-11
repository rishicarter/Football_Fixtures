package rest;

import Response.worldCupFixtureResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by rishi on 10/6/18.
 */

public interface APIInterface {

    @GET("fixtures")
    Call<worldCupFixtureResponse> getFixtures();
    @GET("fixtures")
    Call<worldCupFixtureResponse> getFixtures(@Header("key") String key,@Header("value") String value,@Query("timeFrameStart")String tfs,@Query("timeFrameEnd")String tfe);
    @GET("fixtures")
    Call<worldCupFixtureResponse> getFixtures(@Query("timeFrame")String tf);
    @GET("fixtures")
    Call<worldCupFixtureResponse> getFixtures(@Header("key") String key,@Header("value") String value);
    @GET("fixtures")
    Call<worldCupFixtureResponse> getFixtures(@Header("key") String key, @Header("value") String value, @Query("timeFrame")String tf);

}
