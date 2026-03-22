import java.util.ArrayList;
import java.util.Scanner;

public class array2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        System.out.println("Введите оценки (отрицательное число для завершения):");

        while (true) {
            int grade = scanner.nextInt();

            if (grade < 0) {
                break;
            }

            grades.add(grade);
        }

        if (grades.size() == 0) {
            System.out.println("Оценки не введены.");
            return;
        }
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }

        double average = (double) sum / grades.size();
        System.out.println("Средний балл: " + average);
        int max = grades.get(0);
        for (int g : grades) {
            if (g > max) {
                max = g;
            }
        }
        System.out.println("Максимальный балл: " + max);
    }
}