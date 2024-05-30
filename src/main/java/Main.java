
import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true){
            int people = addProduct.howManyPeople(scanner);
            if (people > 1 || people == 1) {

                ArrayList<String> productsArrayList = new ArrayList<>(addProduct.addProducts(scanner));
                showProducts.showAllProducts(productsArrayList);
                sumAllProducts.sumForEveryone(productsArrayList, people);

                break;
            } else {
                System.out.println("Ошибка! Это некорректное значение для подсчёта!");
            }
        }
    }
}