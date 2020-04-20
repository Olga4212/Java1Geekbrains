package lesson5;

public class Bird extends Animal {
    public Bird(String name) {
        super(name);
        runMax = (float) (5*Math.random() + 2);
        swimMax = 0;
        jumpMax = 0.5f;
    }
}
