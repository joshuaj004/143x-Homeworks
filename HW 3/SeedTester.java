import java.util.*;

public class SeedTester{
    public static void main(String[] args){
        Random r = new Random(42);
        for (int i = 0; i < 25; i++){
            System.out.println(r.nextInt(9) + 1);
        }
    }
}