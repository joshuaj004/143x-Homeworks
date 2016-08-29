public  class QuestionNode {
    //public fields
    String data;
    QuestionNode left;
    QuestionNode right;
    //QuestionNode parent;
    
    public QuestionNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public String toString() {
        return this.data;
    }
}