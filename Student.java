import java.util.HashMap;
import java.util.Scanner;

class students {
    public String name;
    public int rollNo;
    public int age;
    public int marks;

    // constructors ate the methods those have same name as class and they do not
    // have retutrn type ;

    public students(String name, int rollNo, int age, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.marks = marks;
    }

    public void viewStudent() {
        System.out.println("------------------------------------");
        System.out.println("name: " + name);
        System.out.println("rollNo: " + rollNo);
        System.out.println("age: " + age);
        System.out.println("marks: " + marks);
    }
}










public class projectDatabase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, students> database = new HashMap<>();

        while (true) {
            System.out.println("Write 1. Add Student");
            System.out.println("Write 2. View Student");
            System.out.println("Write 3. Search Student");
            System.out.println("Write 4. Calculate Average Marks");
            System.out.println("Write 5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter your rollNo: ");
                    int rollNo = sc.nextInt();
                    System.out.print("enter your age :");
                    int age = sc.nextInt();
                    System.out.print("enter your marks: ");
                    int marks = sc.nextInt();

                    students std = new students(name, rollNo, age, marks);
                    database.put(rollNo, std); // database = { 1: {name, age, marks, rollno},}

                    System.out.println("Student added Sucessfully");
                    break;
                case 2:
                    System.out.println("List of students");
                    for (students i : database.values()) {
                        i.viewStudent();
                    }
                    break;
                case 3:
                    System.out.print("enter your rollNo: ");
                    int roll = sc.nextInt();

                    students data = database.get(roll);
                    if (data != null) {
                        data.viewStudent();
                    } else {
                        System.out.println("Student not found ");
                    }
                    System.out.println("------------------------------------");

                    break;
                case 4:
                    int totalStudents = database.size();
                    int totalMarks = 0;

                    for (students j : database.values()) {
                        totalMarks = totalMarks + j.marks;
                    }

                    double Average = totalMarks / totalStudents;
                    System.out.println("Average marks :" + Average);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}


