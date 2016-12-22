package nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.network;

import nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.model.AnimalResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wesniemarcelin on 12/21/16.
 */

public interface AnimalService {
    @GET("cgi-bin/12_21_2016_exam.pl")
    Call<AnimalResponse> getAnimales();
}
