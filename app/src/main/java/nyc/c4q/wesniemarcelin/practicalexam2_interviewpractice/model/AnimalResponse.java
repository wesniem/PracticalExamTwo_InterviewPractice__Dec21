package nyc.c4q.wesniemarcelin.practicalexam2_interviewpractice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wesniemarcelin on 12/21/16.
 */

public class AnimalResponse {
    @SerializedName("success")
    @Expose
    public boolean success;
    @SerializedName("animals")
    @Expose
    public List<Animal> animals;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
