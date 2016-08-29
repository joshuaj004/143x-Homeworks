import java.util.*;

public class test{
	public static void main(String[] args){
		String String1, varName;
		String1 = ":TEST";
		int i = 61;
		varName = "String" + i;
		System.out.println((varName));
		
		//simple example creating a list form a string array

		String[] myStrings = new String[] {"Elem1","Elem2","Elem3","Elem4","Elem5"};

		List mylist = Arrays.asList(myStrings );

		//getting an iterator object to browse list items

		Iterator itr= mylist.iterator();

		System.out.println("Displaying List Elements,");

		while(itr.hasNext())

		  System.out.println(itr.next());
	}
}