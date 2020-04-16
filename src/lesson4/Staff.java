package lesson4;

public class Staff {
    private String name;
    private int age;
    private float salary;
    private int id;

    private static int lastId = 0;


    public Staff(String _name, int _age, float _salary) {
        name = _name;
        age = _age;
        salary = _salary;

        lastId++;
        id = lastId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }

    public void addSalary(float _addition) {
       salary = salary+_addition;
    }

    public int getId() {
        return id;
    }
}

