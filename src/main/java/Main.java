import static java.lang.Math.floor;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> productsArrayList = new ArrayList<>();
        ArrayList<Double> costArrayList = new ArrayList<>();

        while (true){
            int people = howManyPeople(scanner);
            if (people > 1 || people == 1) {

                addProducts(scanner, productsArrayList, costArrayList, people);

                showAllProducts(productsArrayList, costArrayList);

                sumForEveryone(costArrayList, people);

                break;
            } else {
                System.out.println("Ошибка Это некорректное значение для подсчёта!");
            }
        }
    }

    private static int howManyPeople(Scanner scanner) {

        System.out.println("На какое количество людей необходимо разделить счет?");
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            return 0;
        }
    }

    private static void addProducts(Scanner scanner, ArrayList<String> productsArrayList, ArrayList<Double> costArrayList, int people) {
        scanner.nextLine();
        while (true) {
            System.out.println();
            System.out.println("Введите название товара");
            String product = scanner.nextLine();
            productsArrayList.add(product);

            System.out.println("Введите стоимость товара");
            boolean check = true;
            while (check){
                if (scanner.hasNextDouble()){
                    double cost = scanner.nextDouble();
                    if (cost >= 0) {
                        costArrayList.add(cost);
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
    }

    private static void showAllProducts(ArrayList<String> productsArrayList, ArrayList<Double> costArrayList) {
        System.out.println();
        System.out.println();
        System.out.println("Добавленные товары:");
        System.out.println();
        for (int i = 0; i < costArrayList.size(); i++) {
            System.out.println(productsArrayList.get(i) + " = " + costArrayList.get(i));
        }
    }

    private static void sumForEveryone(ArrayList<Double> costArrayList, int peopleHowMany) {
        System.out.println();
        System.out.println("=========================");
        System.out.println();
        System.out.println("Каждый должен заплатить:");

        double sum = costArrayList.stream().mapToDouble(Double::doubleValue).sum();

        if (sum == 0){
            System.out.printf("%.2f рублей%n", sum);
        } else {
            double finalSum = sum / peopleHowMany;
            int roundedNumber = (int) floor(finalSum);
            String sumFinal = String.valueOf(roundedNumber); //округляем число в меньшую сторону
            int twoLastLetter = sumFinal.length();

            String lastLetter = sumFinal.substring(twoLastLetter-2); //находим 2 последние цифры
            String str = "023456789";
            if(str.contains(String.valueOf(lastLetter.charAt(0)) ))  {
                lastLetter = lastLetter.substring(1);

            }
            switch (lastLetter) {
                case "1":
                    System.out.printf("%.2f рубль%n", finalSum);
                    break;

                case "2", "3", "4":
                    System.out.printf("%.2f рубля%n", finalSum);
                    break;
                case "5", "6", "7", "8", "9", "0", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19":
                    System.out.printf("%.2f рублей%n", finalSum);
                    break;
            }
        }
    }
}



