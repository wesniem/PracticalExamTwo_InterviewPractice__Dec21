package nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.model.Animal;
import nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.model.AnimalResponse;
import nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.network.AnimalService;
import nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.recyclerView.AnimalAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wesniemarcelin on 12/21/16.
 */
public class AnimalFragment extends Fragment {
    private static final String TAG = "YOO";
    private static final String BASE_URL = "http://jsjrobotics.nyc/";
    RecyclerView animalRecyclerView;
    List<Animal> animalList;
    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mroot = inflater.inflate(R.layout.fragment_layout, container, false);
        animalRecyclerView = (RecyclerView) mroot.findViewById(R.id.recycler_view_animals);
        fetchAnimals();
        return mroot;
    }

    private void fetchAnimals() {
        //Retrofit Call
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Service Call
        AnimalService service = retrofit.create(AnimalService.class);
        Call<AnimalResponse> call = service.getAnimales();

        call.enqueue(new Callback<AnimalResponse>() {
            @Override
            public void onResponse(Call<AnimalResponse> call, Response<AnimalResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "SUCCESS!" + response.body().toString());

                        //Tasks to be completed on success
                        AnimalResponse animalResponse = response.body();
                        animalList = animalResponse.getAnimals();


                        Log.d("POJO", "Pojos " + animalList.get(0).getBackground());
                        Log.d("Success", "Made It");

                        animalRecyclerView.setLayoutManager(new LinearLayoutManager(context));

                        AnimalAdapter adapter = new AnimalAdapter(animalList);
                        animalRecyclerView.setAdapter(adapter);

                        Log.d("Adapter", "adapter attached");
                    } else {
                        Log.e(TAG, "Error" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<AnimalResponse> call, Throwable t) {
                Log.d(TAG, "Failure" + t.getMessage());
            }
        });
    }
}
