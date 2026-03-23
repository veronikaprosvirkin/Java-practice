class Student {
    public String id;
    public String name;
    public String email;

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String email() {
        return email;
    }
    public String id() {
        return id;
    }
}