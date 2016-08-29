import java.util.*;
public class ayyLmao{
	public static void main(String[] args){
        Scanner k = new Scanner(System.in);
        System.out.println("START");
        String a = k.next();
        String b = "";
        for (int i = 0; i < a.length(); i++){
            b += a.charAt(i) + " ";
        }


        String[] c = b.split(" ");
		System.out.println(Arrays.toString(c));
        System.out.println(a);
	}
}