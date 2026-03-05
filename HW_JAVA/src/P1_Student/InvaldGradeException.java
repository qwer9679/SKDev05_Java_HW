package P1_Student;

public class InvaldGradeException {
	public static void InvaldException(int grade) throws Exception{
		if(grade > 4 || grade < 1) {	
			throw new Exception("학년은 1~4이여야 합니다.");
		}
	}
}
