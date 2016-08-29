import java.util.*;

public class test {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<String>();
        dictionary.add("a");
        dictionary.add("b");
        dictionary.add("c");
        dictionary.add("d");
        dictionary.add("e");
        System.out.println(dictionary);
        for (int i = dictionary.size() - 1; i >= 0; i--) {
            System.out.println(i + " " + " " + dictionary.remove(i));    
        }
        
        System.out.println(dictionary);
    }
}