package lesson5;

public class Animal {
    protected String name;
    protected float runMax;
    protected float swimMax;
    protected float jumpMax;

    public Animal(String name) {
        this.name = name;
    }

    protected void run(float distance) {
        if (runMax >= distance) {
            System.out.println(name + " can run");
        }
    }

    protected void swim(float distance) {
        if (swimMax >= distance) {
            System.out.println(name + "can swim");
        }
    }

    protected void jump(float height) {
        if (jumpMax >= height) {
            System.out.println(name + "can jump");
        }
    }
}

