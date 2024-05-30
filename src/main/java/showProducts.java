import java.util.ArrayList;

public class showProducts {
    public static void showAllProducts(ArrayList<String> productsArrayList) {
        System.out.println();
        System.out.println();
        System.out.println("Добавленные товары:");
        System.out.println();

        int size = productsArrayList.size();

        for(int i = 0; i < size-1; i = i + 2){
            System.out.println(productsArrayList.get(i) + " = " + productsArrayList.get(i+1));
        }

//        for (String product : productsArrayList) {
//            System.out.println(product);
//        }
    }
}
