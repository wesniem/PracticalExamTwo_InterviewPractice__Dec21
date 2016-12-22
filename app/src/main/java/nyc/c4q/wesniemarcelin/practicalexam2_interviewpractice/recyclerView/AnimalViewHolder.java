package nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.recyclerView;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.AnimalFragment;
import nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.R;
import nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.model.Animal;

/**
 * Created by wesniemarcelin on 12/21/16.
 */
public class AnimalViewHolder extends RecyclerView.ViewHolder {
    private Animal animal;
    TextView animalName;
    AnimalFragment fragment;
    FrameLayout animalLayout;
    AnimalViewHolder viewHolder;
    RecyclerView recyclerView;
    View view;
    public AnimalViewHolder(View itemView) {
        super(itemView);
        animalName = (TextView)itemView.findViewById(R.id.name);
        animalLayout = (FrameLayout) itemView.findViewById(R.id.activity_main);
        recyclerView =(RecyclerView) itemView.findViewById(R.id.recycler_view_animals);
        view = itemView;

    }

    public void bind(final Animal animal) {

        this.animal = animal;
        String color = animal.getTextColor();
        animalName.setTextColor((Color.parseColor(color)));
        animalName.setText((animal.getName()));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//            viewHolder.view.setBackgroundColor(Color.parseColor(animal.getBackground()));
//                animalLayout.setBackgroundColor(Color.parseColor(animal.getBackground()));
                //fragment.getView().setBackgroundColor(Color.parseColor(animal.getBackground()));

                view.setBackgroundColor(Color.parseColor(animal.getBackground()));
//                recyclerView.setBackgroundColor(Color.parseColor(animal.getBackground()));
            }
        });
        Log.d("Success", "Everything is binded");

    }
}
