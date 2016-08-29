import java.util.*;

public class Grammar {
	Map<String, List<String>> grammarRules = new HashMap<String, List<String>>();
	
	public Grammar(List<String> rules) throws IllegalArgumentException {
		System.out.println("UMMMMMM");
		if (rules == null || rules.isEmpty()){
			throw new IllegalArgumentException();
		}
		//System.out.println(Arrays.toString(rules.toArray()));
		System.out.println("LINE 11");
		for (String nonterminals : rules) { 
			/* PURE GARBAGE
			// Convert List<String> to String[] at some point
			// eg pieces[0] == "<propnoun>"
			// eg pieces[1] == "John|Jane|Sally|Spot|Fred|Elmo"
			//pieces[1] = pieces[1].split("\\|");
			// eg pieces[1] = ["John", "Jane", "Sally", "Spot", "Fred", "Elmo"]
			//System.out.print(pieces[0] + "\t\t");
			//System.out.println(Arrays.toString(temp1.toArray()));
			//List<String> temp2 = Arrays.asList(pieces);
			//System.out.println(Arrays.toString(temp.toArray()));
			//System.out.println("*******" + pieces[0]);
			//System.out.println("+++++++" + temp1.toString());
			*/
			String[] pieces = nonterminals.split("::=");
			List<String> temp1 = Arrays.asList(pieces[1]);
			System.out.println(temp1.length());
			for (int i = 0; i < temp1.length(); i++) {
				System.out.print(temp1.get(i));
				System.out.print("*..*");
				System.out.println(temp1.get(i).trim());
				temp1.put(temp1.get(i).trim());
			}	
			if (!this.grammarRules.containsKey(pieces[0])){
				this.grammarRules.put(pieces[0], temp1);
			} else {
				// Implement a private method that makes 2 arraylist strings and returns the combination
				// of them both.
				List<String> a1 = new ArrayList<String>();
				a1.addAll(temp1);
				a1.addAll(this.grammarRules.get(pieces[0]));
				this.grammarRules.put(pieces[0], a1);
			}
			
		}
		System.out.println(this.grammarRules.toString());
	}
	
	
	public boolean isNonTerminal(String symbol) {
		return this.grammarRules.containsKey("<"+symbol+">");
	}
	
	public String toString() {
		return "";
	}
	
	public List<String> getRandom(int number, String nonterminal) {
		return null;//List<String> a = new List<String>();
	}
	
}