public class Task1 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Необходимо ввести 2 аргумента командной строки. Снчала n-массив, потом m-длину обхода");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        if (n <=0 || m < 0) {
            System.out.print("Аргумент n должен целым числом больше 0, аргумент m должен целым неотрицательным числом");
            return;
        }

        int[] circularArray = new int[n];
        for (int i = 0; i < n; i++) {
            circularArray[i] = i + 1;
        }

        int currentIndex = 0;
        StringBuilder path = new StringBuilder();

        do {
            path.append(circularArray[currentIndex]);
            currentIndex = (currentIndex + m-1) % n;
        } while (currentIndex != 0);

        System.out.print(path); // Полученный путь
    }
}
