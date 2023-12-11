package gpacalculator;

public class Course {
    private String courseCode;
    private int courseUnits;
    private int score;

    public Course(String courseCode, int courseUnits, int score) {
        this.courseCode = courseCode;
        this.courseUnits = courseUnits;
        this.score = score;
    }

    public String getTableResult() {
        String grade = calculateGrade();
        int gradePoints = calculateGradePoints();
        return "| " + courseCode + "                    |  " + courseUnits + "                    | " + grade + "          | " + gradePoints + "                   |";
    }

    public int getGradePoints() {
        return calculateGradePoints();
    }

    private int calculateGradePoints() {
        if (score >= 70 && score <= 100) {
            return 5;
        } else if (score >= 60 && score <= 69) {
            return 4;
        } else if (score >= 50 && score <= 59) {
            return 3;
        } else if (score >= 45 && score <= 49) {
            return 2;
        } else if (score >= 40 && score <= 44) {
            return 1;
        } else {
            return 0;
        }
    }

    private String calculateGrade() {
        if (score >= 70 && score <= 100) {
            return "A";
        } else if (score >= 60 && score <= 69) {
            return "B";
        } else if (score >= 50 && score <= 59) {
            return "C";
        } else if (score >= 45 && score <= 49) {
            return "D";
        } else if (score >= 40 && score <= 44) {
            return "E";
        } else {
            return "F";
        }
    }
}
