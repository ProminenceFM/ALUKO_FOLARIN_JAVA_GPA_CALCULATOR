package gpacalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class GPACalculator {
    private Scanner scanner;

    public GPACalculator() {
        this.scanner = new Scanner(System.in);
    }

    public void runGPACalculator() {
        System.out.println("Welcome to My GPA Calculator!!! \n Instructions: Kindly Input Valid data.\n Can take infinite number of Courses.\n Keep inputting data until done. When done type 'done' to get results. \n\n");

        int totalGradeUnits = 0;
        double totalGradePoints = 0.0;
        ArrayList<String> tableResults = new ArrayList<>();

        while (true) {
            String courseCode;
            try{
                System.out.print("Input Course Code (Type 'done' instead when done): ");
                courseCode = scanner.nextLine();

                if (courseCode.equalsIgnoreCase("done")) {
                    break;
                } else if (courseCode.isEmpty()) {
                    System.out.println("Cannot be empty. Please input a valid response.");
                    continue;
                }
            }
            catch (Exception ex){
                System.out.print("Invalid response. Kindly input a valid response.");
                continue;
            }
            

            int courseUnits;
            while (true){
                try{
                    System.out.printf("Input course unit for %s: ", courseCode );
                    courseUnits = Integer.parseInt(scanner.nextLine());

                    if (courseUnits< 0 || courseUnits > 10){
                        System.out.println("Please input units within 0 to 10 only");
                        continue;
                    }
                    else{
                        break;
                    }
                }
                catch (Exception ex) {
                    System.out.println("Empty or Invalid input. Kindly enter a valid Input");
                    continue;
                }
            }

            int score;
            while (true){
                try{
                    System.out.printf("Input score for Course %s: ", courseCode);
                    score = Integer.parseInt(scanner.nextLine());

                    if (score< 0 || score > 100){
                        System.out.println("Please input units within 0 to 100 only");
                        continue;
                    }
                    else{
                        break;
                    }
                }
                catch (Exception ex) {
                    System.out.println("Empty or Invalid Score input. Kindly enter a valid Score");
                    continue;
                }
            }

            Course course = new Course(courseCode, courseUnits, score);

            // Display entered course details
            tableResults.add(course.getTableResult());

            totalGradeUnits += courseUnits;
            totalGradePoints += course.getGradePoints() * courseUnits;
        }

        // Display table header
        System.out.println("Please wait while we load the results... \n");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE              | COURSE UNIT           | GRADE      | GRADE-UNIT          |");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");

        for (String results : tableResults) {
            System.out.println(results);
        }

        // Display table footer
        System.out.println("|---------------------------------------------------------------------------------------|");

        if (totalGradeUnits > 0) {
            double gpa = totalGradePoints / totalGradeUnits;
            System.out.printf("Your GPA is = %.2f to 2 decimal places.%n", gpa);
        } else {
            System.out.println("No courses entered. GPA cannot be calculated.");
        }

        scanner.close();
    }

}
