package lt.kvk.i9.jauga_dovydas.model;

public class User {
    private String name;
    private long number;
    private float percent;

    public User(String nam, long num, float perc){
        name = nam;
        number = num;
        percent = perc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
