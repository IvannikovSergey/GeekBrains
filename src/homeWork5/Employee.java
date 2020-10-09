package homeWork5;

public class Employee {
    String fullName;
    String position;
    String eMail;
    String telNumber;
    int salary;
    int age;

    public Employee(String fullName, String position, String eMail, String telNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.eMail = eMail;
        this.telNumber = telNumber;
        this.salary = salary;
        this.age = age;
    }

    public static void info(Employee arr) {

        System.out.println("ФИО: " + arr.fullName + "\n" + "Должность: " + arr.position + "\n" + "Email: " + arr.eMail + "\n" +
                "Номер телефона: " + arr.telNumber + "\n" + "Зарплата: " + arr.salary + "\n" + "Возраст: " + arr.age);
        System.out.println();
    }

    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Ivanov Ivan", "ingineer", "xxx.com", "+998(99)9999999)", 1000, 41);
        persArray[1] = new Employee("Sidorov Sidor", "nachalnik", "obuv.com", "+998(99)8888888)", 2000, 47);
        persArray[2] = new Employee("Petrov Petr", "emp1", "yyy.com", "+998(99)7777777)", 800, 23);
        persArray[3] = new Employee("Noutbukov Noutbuk", "it", "it.com", "+998(99)0101011)", 3000, 30);
        persArray[4] = new Employee("Director", "director", "director.com", "+998(99)55555555)", 5000, 55);
        for (Employee emp : persArray) {
            if (emp.age > 40) {
                info(emp);
            }
        }
    }
}
