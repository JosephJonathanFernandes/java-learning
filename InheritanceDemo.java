class Person {
    String name;
    void speak() {
        System.out.println(name + " is speaking.");
    }
}

class Student extends Person {
    int rollNo;
    void study() {
        System.out.println(name + " is studying.");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Joseph";
        s.rollNo = 101;
        s.speak();
        s.study();
    }
}
