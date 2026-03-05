package P1_Student;
import P1_Student.InvaldGradeException;

public class Student {
    String name;
    private String major;
    private int grade;

    public void getStudentId(String inputname, String inputmajor, int inputgrade) {
        name = inputname;
        major = inputmajor;
        grade = inputgrade;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int input) {
    	try {
    		System.out.println(input + "학년으로 변경");
        	InvaldGradeException.InvaldException(input);
            this.grade = input;
            System.out.printf("학년이 %d으로 변경되었습니다.%n", input);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
}