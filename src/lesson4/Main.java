package lesson4;

public class Main {

    public static void main(String[] args) {
        Staff direktor = new Staff("Иванов Иван Иванович", 55, 1000000);
        System.out.printf("ФИО %s, возраст %d\n", direktor.getName(), direktor.getAge());

        Staff[] workers = {
                new Staff("Иванов Иван Иванович", 55, 1000000),
                new Staff("Петров Иван Иванович", 35, 100000),
                new Staff("Сидоров Иван Иванович", 45, 10000),
                new Staff("Кашкин Иван Иванович", 95, 13000),
                new Staff("Кружкин Иван Иванович", 18, 144000)
        };

        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getAge() >= 40) {
                System.out.printf("id %d, ФИО %s, возраст %d, зарплата %f\n", workers[i].getId(), workers[i].getName(), workers[i].getAge(), workers[i].getSalary());
            }
        }

        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getAge() >= 45) {
                workers[i].addSalary(5000);
                System.out.printf("ФИО %s, возраст %d, зарплата %f\n", workers[i].getName(), workers[i].getAge(), workers[i].getSalary());
            }
        }

        float averageAge = 0;
        float averageSalary = 0;
        for (int i = 0; i < workers.length; i++) {
            averageAge = averageAge+workers[i].getAge();
            averageSalary = averageSalary+workers[i].getSalary();
        }
        averageAge = averageAge / workers.length;
        averageSalary = averageSalary / workers.length;
        System.out.printf("Средний возраст сотрудника %f\n", averageAge);
        System.out.printf("Средний зарплата сотрудника %f\n", averageSalary);



//        for(int i=0; i<args.length;i++) {
//            System.out.println(args[i]);
//        }

    }
}
