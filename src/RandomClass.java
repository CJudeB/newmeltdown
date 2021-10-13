import java.util.Random;

public class RandomClass {



    public static void main(String[] args) {

        //1 or 2
        Random x = new Random();
        System.out.println(x.nextInt(2 + 1));
        //between 1-3
        Random y = new Random();
        System.out.println(y.nextInt((2 + 1) + 1));
        //between 1-4
        Random z = new Random();
        System.out.println(z.nextInt((3 + 1) + 1));
        //between 1 and 20
        Random r = new Random();
        System.out.println(r.nextInt((19 + 1) + 1));
    }


}
