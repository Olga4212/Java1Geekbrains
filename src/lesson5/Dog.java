package lesson5;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
        runMax = 500;
        swimMax = (float) (5*Math.random() + 7);
        jumpMax = 0.5f;
    }
}
