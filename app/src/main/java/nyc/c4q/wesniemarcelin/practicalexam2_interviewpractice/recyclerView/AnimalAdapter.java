package nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.R;
import nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.model.Animal;

/**
 * Created by wesniemarcelin on 12/21/16.
 */

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    List<Animal> mAnimalList;

    public AnimalAdapter(List<Animal> mAnimalList) {
        this.mAnimalList = mAnimalList;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item_view, parent, false);
        return new AnimalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        Animal animal = mAnimalList.get(position);
        holder.bind(animal);

    }

    @Override
    public int getItemCount() {
        return mAnimalList.size();
    }
}
