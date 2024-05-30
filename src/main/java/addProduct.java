import java.util.ArrayList;
import java.util.Scanner;

public class addProduct {
    public static ArrayList<String>  addProducts(Scanner scanner) {
        ArrayList<String> productsArrayList = new ArrayList<>();
        scanner.nextLine();
        while (true) {
            System.out.println();
            System.out.println("Введите название товара");

            boolean checkLine = true;

            while (checkLine) {
                String product = scanner.nextLine();
                if (!product.isEmpty()) {
                    productsArrayList.add(product);
                    checkLine = false;
                } else {
                    System.out.println("Ошибка! Введите название товара");
                }
            }

            System.out.println("Введите стоимость товара");
            boolean check = true;
            while (check){
                if (scanner.hasNextDouble()){
                    double cost = scanner.nextDouble();
                    if (cost >= 0) {
                        productsArrayList.add(String.valueOf(cost));
                        check = false;
                    } else {
                        System.out.println("Вы ввели отрицательное число! Введите стоимость товара");
                    }
                } else {
                    System.out.println("Некорректный ввод данных! Введите стоимость товара");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();
            System.out.println("Товар успешно добавлен!");
            System.out.println("-----------------------");
            System.out.println();
            System.out.println("Хотите продолжить? Для завершения ввода используйте команду 'завершить'");
            String yesOrBreak = scanner.nextLine();

            if (yesOrBreak.equalsIgnoreCase("завершить")){
                break;
            }
        }
        return productsArrayList;
    }


    public static int howManyPeople(Scanner scanner) {
        System.out.println("На какое количество людей необходимо разделить счет?");
        boolean check = true;
        while (check){

            if (scanner.hasNextInt()) {
                check = false;
            } else {
                System.out.println("Ошибка! Это некорректное значение для подсчёта!");
                scanner.nextLine();
            }
        }
        return scanner.nextInt();

    }
}