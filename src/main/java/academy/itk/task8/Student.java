package academy.itk.task8;

import java.util.Map;

class Student {

    private String name;
    private Map<String, Integer> grades;

    public Student(String name, Map<String, Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return this.name + " " + this.grades;
    }
}
