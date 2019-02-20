package lamdaTest;

public class Grape {
    private int weight = 0;
    private String color = "";

    public Grape(int weight, String color){
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Grape{" +
               "color='" + color + '\'' +
               ", weight=" + weight +
               '}';
    }
}