package School.models;

public class Score {

    private final String course;
    private final float value;

    public Score(String course, float value) {
        this.course = course;
        this.value = value;
    }

    public String getCourse() {
        return course;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Score{" +
                "course='" + course + '\'' +
                ", value=" + value +
                '}';
    }
}
