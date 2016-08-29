import java.util.Scanner;
import java.io.*;


public  class QuestionsGame {
    QuestionNode front;   
    
    public QuestionsGame(String object) {
        this.front = new QuestionNode(object);
    }
    
    public QuestionsGame(Scanner input) {
        String line;
        line = input.nextLine();
        this.front = new QuestionNode(input.nextLine());
        nodeAssembler(this.front, input);
        
    }
    
    public void play() {
        QuestionNode current = this.front;
        Scanner input = new Scanner(System.in);
        while (current.left != null)  {
            System.out.print(current.data + " (y/n)? ");
            if (input.nextLine().trim().toLowerCase().startsWith("y")){
                current = current.left;
            } else {
                current = current.right;
            }
        }
        System.out.println("I guess that your object is " + current.data + "!");
        System.out.print("Am I right? (y/n)? ");
        if (input.nextLine().trim().toLowerCase().startsWith("y")){
            System.out.println("Awesome! I win!");
        } else {
            learner(current, input);
        }
    }
    
    private void learner(QuestionNode current, Scanner input) {
        QuestionNode parent = questionFailNode(this.front, current.data);
        System.out.println("Boo! I Lose.  Please help me get better!");
        System.out.print("What is your object? ");
        String object = input.nextLine().trim();
        System.out.println("Please give me a yes/no question that distinguishes between " + object + " and " + current.data + ".");
        String question = input.nextLine();
        question = question.substring(3);
        System.out.print("Is the answer \"yes\" for " + object + "? (y/n)? ");
        boolean response = input.nextLine().trim().toLowerCase().startsWith("y");
        QuestionNode tempPointer;
        if (parent.left == null) {
            this.front = new QuestionNode(question);
            tempPointer = this.front;
        } else if (parent.left.data.equals(current.data)) {
            parent.left = new QuestionNode(question);
            tempPointer = parent.left;
        } else {
            parent.right = new QuestionNode(question);
            tempPointer = parent.right;
        }
        if (response) {
            tempPointer.left = new QuestionNode(object);
            tempPointer.right = new QuestionNode(current.data);
        } else {
            tempPointer.right = new QuestionNode(object);
            tempPointer.left = new QuestionNode(current.data);
        }
    }
    
    private QuestionNode questionFailNode(QuestionNode node, String object) {
        if (node.left == null && node.data.equals(this.front.data)){
            return this.front;
        } else if (node.left == null) {
            return null;
        } else if (node.left.data.equals(object) || node.right.data.equals(object)) {
            return node;
        } else {
            QuestionNode left = questionFailNode(node.left, object);
            if (left != null) {
                return left;
            } else {
                return questionFailNode(node.right, object);
            }            
        }
    }
    
    private void nodePrint(QuestionNode node, int level) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.data + "\t\t" + level);
            level++;
            nodePrint(node.left, level);
            nodePrint(node.right, level);
        }
    }
    
    private void nodeAssembler(QuestionNode node, Scanner input) {
        while (input.hasNextLine()) {
            if (input.nextLine().equals("Q:")) {
                if (node.left == null) {
                    node.left = new QuestionNode(input.nextLine());
                    nodeAssembler(node.left, input);
                } else {
                    node.right = new QuestionNode(input.nextLine());
                    nodeAssembler(node.right, input);
                    return;
                }
            } else {
                if (node.left == null) {
                    node.left = new QuestionNode(input.nextLine());
                } else {
                    node.right = new QuestionNode(input.nextLine());
                    return;
                }
            } 
        }
    }
    
    public void saveQuestions(PrintStream output) {
        privateSaveQuestions(this.front, output);
    }
    
    private void privateSaveQuestions(QuestionNode node, PrintStream output) {
        if (node == null) {
            return;
        } else {
			if (node.left != null) {
                output.println("Q:");
            } else {
                output.println("A:");
            }
            output.println(node.data);
            privateSaveQuestions(node.left, output);
            privateSaveQuestions(node.right, output);
        }
    }
}