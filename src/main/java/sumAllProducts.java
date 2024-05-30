import java.util.ArrayList;

import static java.lang.Math.floor;

public class sumAllProducts {

    public static void sumForEveryone(ArrayList<String> productsArrayList, int people) {


        ArrayList<Double> costArrayList = new ArrayList<>();

        //добавление в массив costArrayList 099
        int size = productsArrayList.size();
        for (int i = 0; i < (size-1); i = i + 2){
            costArrayList.add(Double.valueOf(productsArrayList.get(i+1)));
        }





        System.out.println();
        System.out.println("=========================");
        System.out.println();
        System.out.println("Каждый должен заплатить:");

        double sum = costArrayList.stream()
                .mapToDouble(Double::doubleValue)
                .sum();



        if (sum == 0) {
            System.out.printf("%.2f рублей%n", sum);
        } else {
            double finalSum = sum / people;


            int roundedNumber = (int) floor(finalSum);
            String sumFinal = String.valueOf(roundedNumber);

            int twoLastLetter = sumFinal.length() > 1? sumFinal.length() - 1 : 0;

            String lastLetter = sumFinal.substring(twoLastLetter);


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
