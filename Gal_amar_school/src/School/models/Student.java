package School.models;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private final List<Score> scores;

    public Student() {

        this.scores = new ArrayList<>();
    }

    public List<Score> getScores() {
        return scores;
    }

    public double getAverageScore() {
        double sum = 0;
        for(Score score : scores) {
            sum += score.getValue();
        }
        return scores.size() == 0 ? 0 : sum / scores.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() + ", " +
                "scores=" + getAverageScore() +
                '}';
    }
}