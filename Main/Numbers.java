package MyRepository.Main;

import java.util.Scanner;

public class Numbers {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int num = scanner.nextInt(), counter = 0;

        for (int i = 0; i < num; i++){
            if (!String.valueOf(i).matches(".*[2-9].*"))
                counter++;
        }
        System.out.println(counter);



    }
}
