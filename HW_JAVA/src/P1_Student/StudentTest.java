package P1_Student;

import P1_Student.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student std = new Student();

        std.getStudentId("±è¹Î¼ö", "ÄÄÇ»ÅÍ°øÇĞ", 3);
        
        System.out.println(std.getName() + " / " + std.getMajor() + " / " + std.getGrade());
        std.setGrade(5);
    }
}
