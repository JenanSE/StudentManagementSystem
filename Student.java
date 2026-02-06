package studentmanagementsystem;

public class Student {

    private int id;
    private String name;
    private double gpa;

    //Full constructor
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    //Default constructor=> to reduce the errors occuring
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override //not adding it in the exams = I will get zero
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | GPA: " + gpa;
    }
}
