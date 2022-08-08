import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    Converter converter = new Converter();
    Scanner scanner = new Scanner(System.in);

    int defaultStep = 10000;
    int maxCount = 0;
    int count = 0;
    int max = 0;
    int sum = 0;

    HashMap<Integer, MonthData> MonthToData = new HashMap<>();

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            MonthToData.put(i, new MonthData());
        }
    }

    static class MonthData {
        int[] dayStep = new int[30];

    }

    public void changeStep() {
        System.out.println("Введите желаемое количество шагов: ");
        defaultStep = scanner.nextInt();
        if (defaultStep >= 0) {
            System.out.println("Ваше количество шагов установлено в размере: " + defaultStep);
        } else {
            System.out.println("Введено неверное количество шагов");
        }
    }

    public void addSteps() {
        System.out.println("Введите месяц в который хотите ввести шаги:");
        int month = scanner.nextInt();

        System.out.println("Введите день в который хотите ввести шаги:");
        int day = scanner.nextInt();

        System.out.println("Введите количество шагов:");
        int steps = scanner.nextInt();
        if (month >= 0 & month < 12 & day > 0 & day <= 30 & steps >= 0) {
            MonthToData.get(month).dayStep[day - 1] = steps;
            System.out.println("Значение сохранено!");
        } else {
            System.out.println("Некорректно введены данные!");
        }
    }

    public void statistics() {

        System.out.println("Введите месяц по которому хотите получить статистику:");
        int month = scanner.nextInt();

        if (MonthToData.containsKey(month)) {
            for (int i = 0; i < MonthToData.get(month).dayStep.length; i++) {
                System.out.println((i + 1) + " день: " + MonthToData.get(month).dayStep[i]);
            }

            totalNumberSteps(month);

            stepCounting(month);

            converter.convertKilometers(sum);

            converter.convertCalories(sum);

            bestSeries(month);

        } else {
            System.out.println("Неверно указан месяц!");
        }
    }

    public void bestSeries(int month) {
        for (Integer countDay : MonthToData.get(month).dayStep) {
            if (countDay >= defaultStep) {
                count++;
            } else {
                if (count >= maxCount) {
                    maxCount = count;
                }
                count = 0;
            }
        }
        System.out.println("Лучшая серия дней: " + maxCount);
    }

    public void stepCounting(int month) {
        for (int i = 0; i < MonthToData.get(month).dayStep.length; i++) {
            if (max < MonthToData.get(month).dayStep[i]) {
                max = MonthToData.get(month).dayStep[i];
            }
        }
        System.out.println("Максимальное количество шагов равно: " + max);

        int mediumStep = sum / MonthToData.get(month).dayStep.length;
        System.out.println("Среднее количество шагов: " + mediumStep);
    }

    public void totalNumberSteps(int month) {
        for (int i = 0; i < MonthToData.get(month).dayStep.length; i++) {

            sum = sum + MonthToData.get(month).dayStep[i];
        }
        System.out.println("Общее количество шагов за месяц: " + sum);
    }
}
