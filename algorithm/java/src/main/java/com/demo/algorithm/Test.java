package com.demo.algorithm;

public class Test {

    public static void main(String[] args) {
        int a = 3;
        short b = (short) a;


        long c = a;


        byte[] bytes = {1, 2, 3};

        byte[] bytes1 = new byte[10];
        for (byte b1 : bytes1) {
            System.out.println(b1);
        }
        bytes1[0] = 1;

        bytes1[10] = 10;

        for (int i = 0; i < bytes1.length; i++) {
            System.out.println(bytes1[i]);
        }

        Student student = new Student();
        // Student student1 = new Student(1, "test", 1);
        student.study();
        System.out.println(Student.name);

        Student.hello();
        // Student.study();

        final int x = 3;
        // x = 4;
        final Student s1 = new Student();
        s1.id = 2;
        // s1 = new Student();


        Hello h1 = () -> { };


        Person person = new Student();
        Hello h2 = new World();

    }
}

class Student extends Person {

    // public Student() {
    // }


    // public Student(int id, String name, int age) {
    //     this.id = id;
    //     this.name = name;
    //     this.age = age;
    // }

    public int id;
    public static String name;
    private int age;

    @Override
    public void study() {
        super.study();
    }

    public static void hello() {

    }
}

class Person {
    public void study() {

    }
}



interface Hello {

    default void hello() {

    }

    void a();
}

class World implements Hello {

    @Override
    public void a() {

    }
}
