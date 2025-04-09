import java.util.*;

// Class to store each student's information and scores
class Student {
    String id;
    int javaScore;
    int sqlScore;
    int mathScore;
    int englishScore;
    double average;
    int rank;

    public Student(String id, int javaScore, int sqlScore, int mathScore, int englishScore) {
        this.id = id;
        this.javaScore = javaScore;
        this.sqlScore = sqlScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.calculateAverage();
    }

    // Calculates average score for the student

    public void calculateAverage() {
        this.average = (javaScore + sqlScore + mathScore + englishScore) / 4.0;
    }
    // Displays student score and status
    public void printStatus() {
        System.out.println("-------------------------------------------");
        System.out.println("[" + id + "] Student’s Score Status");
        System.out.println("Java " + javaScore + ", SQL " + sqlScore + ", Math. " + mathScore + ", English " + englishScore);
        System.out.printf("Avg. : %.2f, Rank : %d\n", average, rank);
        System.out.println("-------------------------------------------");
    }
}

public class JAVA_MISSION_1_DiegoMedina {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many students are in this class? : ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Student[] students = new Student[n];

        // Variables to track total scores per subject
        double totalJava = 0;
        double totalSQL = 0;
        double totalMath = 0;
        double totalEnglish = 0;

        // Input score
        for (int i = 0; i < n; i++) {
            String id = String.format("STD%02d", i + 1);
            System.out.println();

            System.out.print(id + " Student's Java Score : ");
            int java = sc.nextInt();
            System.out.print(id + " Student's SQL Score : ");
            int sql = sc.nextInt();
            System.out.print(id + " Student’s Math. Score : ");
            int math = sc.nextInt();
            System.out.print(id + " Student’s English Score : ");
            int english = sc.nextInt();

            students[i] = new Student(id, java, sql, math, english);

            totalJava += java;
            totalSQL += sql;
            totalMath += math;
            totalEnglish += english;
        }

        // Ranking (by descending average)
        Arrays.sort(students, (a, b) -> Double.compare(b.average, a.average));
        for (int i = 0; i < n; i++) {
            students[i].rank = i + 1;
        }

        // Show individual status
        for (Student s : students) {
            s.printStatus();
        }

        // Show final ranking
        System.out.println("Final Ranking:");
        for (Student s : students) {
            System.out.printf("%s : => Avg. : %.2f, Rank : %d\n", s.id, s.average, s.rank);
        }

        // Averages by subject
        System.out.println("===============================");
        System.out.printf("Java Class Avg. : %.2f\n", totalJava / n);
        System.out.printf("SQL Class Avg. : %.2f\n", totalSQL / n);
        System.out.printf("Math. Class Avg. : %.2f\n", totalMath / n);
        System.out.printf("English Class Avg. : %.2f\n", totalEnglish / n);
        System.out.println("===============================");

        sc.close();
    }
}
