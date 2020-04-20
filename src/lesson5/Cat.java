package lesson5;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
        runMax = (float) (100*Math.random() + 150);
        swimMax = 0;
        jumpMax = 2;
    }
}
