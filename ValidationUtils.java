package INTERNSHIP;

public class ValidationUtils {
	public static boolean validateAge(int age) {
        return age > 0;
    }

    public static boolean validateGrade(double grade) {
        return grade >= 0 && grade <= 100;
    }

}
