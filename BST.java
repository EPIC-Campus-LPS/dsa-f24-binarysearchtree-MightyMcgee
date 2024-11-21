public class BST{
    private int size;
    private TreeNode root;

    public BST(){
        size = 0;
        root = null;
    }
    public <E> void add(E value){
        TreeNode newNode = new TreeNode((Comparable) value, null, null);
        TreeNode currNode = root;
        if (size == 0){
            root = newNode;
            size++;
        }
        while(!(newNode.getLeftChild() == null) && !(newNode.getRightChild() == null)){
            if (newNode.getValue().compareTo(currNode.getValue())<=0){
                currNode = currNode.getLeftChild();
            }
            else if (newNode.getValue().compareTo(currNode.getValue())>0){
                currNode = currNode.getRightChild();
            }
        }
        if (newNode.getValue().compareTo(currNode.getValue())<=0){
            currNode.setLeftChild(newNode);
            size++;
        }
        else if (newNode.getValue().compareTo(currNode.getValue())>0){
            currNode.setRightChild(newNode);
            size++;
        }
    }

    public <E> boolean contains(E value){

        return false;
    }

    public int countNodes(){
        return size;
    }

    public int countLeafNodes(){

        return 0;
    }

    public int getHeight(){

        return 0;
    }

    public void printInorder(){

    }
    public String InorderHelper(TreeNode currNode){
        String output = "";
        
        return output;
    }

    public void printPreorder(){

    }

    public void printPostorder(){

    }

    public <E> E delete(E value){

        return value;
    }
}
