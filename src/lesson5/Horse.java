package lesson5;

public class Horse extends Animal{String name;

    public Horse(String name) {
        super(name);
        runMax = 1500;
        swimMax = 100;
        jumpMax = (float) (2*Math.random() + 2);
    }
}
