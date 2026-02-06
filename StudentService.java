package studentmanagementsystem;

public class StudentService {

    private Student[] students;
    private int count;

    public StudentService(int size) {
        students = new Student[size]; //composition=> Strong ownership
        count = 0;
    }

    public boolean addStudent(Student s) {
        if (count >= students.length) {
            return false; // array full
        }
        if (findIndexById(s.getId()) != -1) {
            return false; // id already exists
        }
        students[count] = s;
        count++;
        return true;
    }

    public void printAllStudents() {
        if (count == 0) {
            System.out.println("No students yet.");
            return;
        }

        System.out.println("---- Students List ----");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }

    public Student searchById(int id) {
        int idx = findIndexById(id);
        if (idx == -1) {
            return null;
        }
        return students[idx];
    }

    public boolean deleteById(int id) {
        int idx = findIndexById(id);
        if (idx == -1) {
            return false;
        }

        // shift left
        for (int i = idx; i < count - 1; i++) {
            students[i] = students[i + 1];
        }
        students[count - 1] = null;
        count--;
        return true;
    }

    private int findIndexById(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
