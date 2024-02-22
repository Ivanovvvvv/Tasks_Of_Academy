import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Введите пути в аргументе командной строки. Сначала путь к файлу с центром и радиусом окружности(file1.txt), затем через пробел к файлу с координатами точек(file2.txt)");
            return;
        }

        String pathFile1 = args[0];
        String pathFile2 = args[1];

        // Получение центра и радиуса окружности из файла 1
        float[] centerAndRadius = readFile1(pathFile1);
        float centerX = centerAndRadius[0];
        float centerY = centerAndRadius[1];
        float radius = centerAndRadius[2];

        // Обработка точек из файла 2 и вывод на консоль результатов
        readDotsFromFile2(pathFile2, radius, centerX, centerY);
    }

    private static float[] readFile1(String file1) throws IOException {
        float[] centerAndRadiusFromFile1 = new float[3];
        BufferedReader brFile1 = new BufferedReader(new FileReader(file1));
        String line1 = brFile1.readLine();
        if (line1 != null) {
            String[] stringArray = line1.split(" ");

            centerAndRadiusFromFile1[0] = Float.parseFloat(stringArray[0]);
            centerAndRadiusFromFile1[1] = Float.parseFloat(stringArray[1]);

            String line2 = brFile1.readLine();
            centerAndRadiusFromFile1[2] = Float.parseFloat(line2);
        }
        return centerAndRadiusFromFile1;
    }

    private static void readDotsFromFile2(String fileName2, float radius, float centerX, float centerY) throws IOException {
        int dotCount = 1;
        BufferedReader points = new BufferedReader(new FileReader(fileName2));
        String line;
        while ((line = points.readLine()) != null && dotCount<101) {
            String[] coordinates = line.split(" ");
            float dotX = Float.parseFloat(coordinates[0]);
            float dotY = Float.parseFloat(coordinates[1]);

            float distance = (float) Math.sqrt(Math.pow(dotX - centerX, 2) + Math.pow(dotY - centerY, 2));

            if (distance == radius) {
                System.out.println("0"); // 0 - точка лежит на окружности
            } else if (distance < radius) {
                System.out.println("1"); // 1 - точка внутри
            } else {
                System.out.println("2"); // 2 -точка снаружи
            }
            dotCount++;
        }
    }
}