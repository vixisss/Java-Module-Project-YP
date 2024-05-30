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
            String sumFinal = String.valueOf(roundedNumber); //округляем число в меньшую сторону

            int twoLastLetter = sumFinal.length();
            String lastLetter = sumFinal.substring(Math.max(0, twoLastLetter-2) ); //находим 2 последние цифры

            String str = "23456789";
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
