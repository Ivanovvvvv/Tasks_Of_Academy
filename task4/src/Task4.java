import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
// Программа будет считывать числа из файла согласно примеру, указанному в задании. каждое строка должна быть занята одним числом и не содержать пробелов
public class Task4 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Не указан путь к файлу.");
            return;
        }

        String filePath = args[0];
        List<Integer> nums = readNumbersFromFile(filePath);
        if (nums.isEmpty()) {
            System.out.println("Файл пуст или не содержит чисел.");
            return;
        }

        int minMoves = findMinMoves(nums);
        System.out.println(minMoves);//Вывод минимального количества ходов
    }
    // Считываем числа из файла и перобразуем его в список
    private static List<Integer> readNumbersFromFile(String filePath) {
        List<Integer> nums1 = new ArrayList<>();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    int num = Integer.parseInt(line);
                    nums1.add(num);
                } catch (NumberFormatException e) {
                    System.out.println("Некорректное число в файле: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
        }
        return nums1;
    }
    // Находим минимальное число шагов для того чтобы числа были одинаковыми
    private static int findMinMoves(List<Integer> nums2) {
        int median = findMedian(nums2);
        return nums2.stream().mapToInt(num -> Math.abs(num - median)).sum();
    }
    // Находим медиану списка
    private static int findMedian(List<Integer> nums3) {
        Collections.sort(nums3);
        int sizeofList = nums3.size();
        //При
        return sizeofList % 2 == 0 ? (nums3.get(sizeofList / 2 - 1) + nums3.get(sizeofList / 2)) / 2 : nums3.get(sizeofList / 2);
    }
}