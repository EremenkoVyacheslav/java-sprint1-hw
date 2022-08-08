public class Converter {
    int getKilometers;
    int getCalories;
    public void convertKilometers(int sum) {
        getKilometers = ((sum * 75) / 100000);
        System.out.println("Пройденная дистанция в км равна: " + getKilometers);
    }

    public void convertCalories(int sum) {
        getCalories = ((sum * 50) / 1000);
        System.out.println("Количество потраченных килокалорий равно: " + getCalories);
    }
}

