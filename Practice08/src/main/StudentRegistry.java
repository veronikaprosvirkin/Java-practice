import java.util.*;

public class StudentRegistry {
    List<Student> students = new ArrayList<>();
    Set<String> emails = new HashSet<>();
    Map<String, Student> studentMap = new HashMap<>();

    public boolean addStudent(Student student) {
        if (emails.contains(student.email()) || studentMap.containsKey(student.id())) {
            return false;
        }
        students.add(student);
        emails.add(student.email());
        studentMap.put(student.id(), student);
        return true;
    }
    public Student findById(String id) {
        return studentMap.get(id);
    }
    public boolean containsEmail(String email) {
        return emails.contains(email);
    }
    public void removeById(String id) {
        Student student = studentMap.remove(id);
        if (student != null) {
            emails.remove(student.email());
            students.remove(student);
        }
    }
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();
        Student s1 = new Student("1", "User1", "user1@ukma");
        Student s2 = new Student("2", "User2", "user1@ukma");
        Student s3 = new Student("3", "User3", "user3@ukma");
        System.out.println("Added user1 "+registry.addStudent(s1));
        System.out.println("Added user2 (duplicate email) "+registry.addStudent(s2));
        System.out.println("Added user3 "+registry.addStudent(s3));
        System.out.println("Is email user1@ukma in system ? "+registry.containsEmail("user1@ukma"));
        registry.removeById("1");
        System.out.println("Deleted user1");
        System.out.println("Is email user1@ukma in system ? "+registry.containsEmail("user1@ukma"));
        System.out.println("Added user2 (add again) "+registry.addStudent(s2));

        System.out.println("=====Task 4=====");
        HashSet<Student> students = new HashSet<>();

        Student st1 = new Student("1", "Veronika", "ver@test.com");
        Student st2 = new Student("1", "User2", "other@test.com");

        students.add(st1);
        boolean isAddedSt2 = students.add(st2);

        System.out.println("Did we add user2 " + isAddedSt2);
        System.out.println("Elements number: " + students.size());
    }
}
