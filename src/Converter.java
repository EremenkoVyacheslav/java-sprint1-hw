public class Converter {
    int km;
    int kal;
    public void km(int sum) {
        km = ((sum * 75) / 100000);
        System.out.println("Пройденная дистанция в км равна: " + km);
    }

    public void kal(int sum) {
        kal = ((sum * 50) / 1000);
        System.out.println("Количество потраченных килокалорий равно: " + kal);
    }
}
