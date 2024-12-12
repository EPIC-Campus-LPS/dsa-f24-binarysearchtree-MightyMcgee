import java.util.SequencedSet;

public class BST{
    private int size;
    private TreeNode root;
    private String output;

    public BST(){
        size = 0;
        root = null;
        output = "";
    }

    /**
     * adds a new node to the tree
     * @param value the value contained within the node
     * @param <E> datatype of value
     */
    public <E> void add(E value){
        TreeNode newNode = new TreeNode((Comparable) value, null, null);
        TreeNode currNode = root;
        if (size == 0){
            root = newNode;
            currNode = root;
            size++;
            return;
        }
        while(!(currNode.getLeftChild() == null) && !(currNode.getRightChild() == null)){
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

    /**
     * checks if a specified value is in the tree
     * @param value the value to check for
     * @return true if the value is present and false if it's not
     * @param <E> datatype of value
     */
    public <E> boolean contains(E value){ //check if this works
        TreeNode currNode = root;
        while(!(currNode.getLeftChild() == null) && !(currNode.getRightChild() == null)){
            if (currNode.getValue().compareTo(value) == 1){
                currNode = currNode.getLeftChild();
                if (currNode.getValue().compareTo(value) == 0){
                    return true;
                }
            }
            else if (currNode.getValue().compareTo(value) < 1){
                currNode = currNode.getRightChild();
                if (currNode.getValue().compareTo(value) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * finds out how many nodes are in the tree
     * @return the amount of nodes
     */
    public int countNodes(){
        return size;
    }

    /**
     * calls leafhelper
     * @return the amount of leafnodes
     */
    public int countLeafNodes(){
        return leafHelper(root);
    }

    /**
     * counts the amount of nodes that have no children
     * @param currNode the node that is being checked for children
     * @return if the noded being checked doesnt exist return 0 if the node has no children return 1 and if it's not a leafnode return the next nodes to check
     */
    public int leafHelper(TreeNode currNode){
        if (currNode == null){
            return 0;
        }if(currNode.getLeftChild() == null && currNode.getRightChild() == null) {
            return 1;
        }
        else {
            return leafHelper(currNode.getLeftChild()) + leafHelper(currNode.getRightChild());
        }
    }

    /**
     * calls helper height
     * @return the height of the tree
     */
    public int getHeight(){

        return helperHeight(root)-1;
    }

    /**
     *
     * @param currNode
     * @return
     */
    public int helperHeight(TreeNode currNode){
        if(currNode.getLeftChild() != null && currNode.getRightChild() != null) {
            return Math.max(helperHeight(currNode.getLeftChild()), helperHeight(currNode.getRightChild()) + 1);
        } else if (currNode.getRightChild() != null){
            return 1 + helperHeight(currNode.getRightChild());
        } else if (currNode.getLeftChild() != null){
            return 1 + helperHeight(currNode.getLeftChild());
        } else {
            return 1;
        }
    }

    /**
     * calls in order helper
     */
    public void printInorder(){
        InorderHelper(root);
    }

    /**
     * traverses to the bottom left of the tree and prints left child, parent, and right child until all nodes are printed
     * @param currNode node being checked for left and right children
     * @return all nodes in order of the pattern
     */
    public String InorderHelper(TreeNode currNode){
        if(currNode == null){
            return null;
        }
        InorderHelper(currNode.getLeftChild());
        System.out.print(currNode.getValue() + " ");
        InorderHelper(currNode.getRightChild());
        return output += currNode.getValue();
    }

    /**
     * calls helperpre
     */
    public void printPreorder(){
        helperPre(root);
    }

    /**
     * prints the root and prints all left children then right children, if a node with 2 children is encountered it prints the parent then traverses the left side then right
     * @param currNode node being added to the output
     * @return all nodes in order of the pattern
     */
    public String helperPre(TreeNode currNode){
        if (currNode == null) {
            return null;
        } else {
            System.out.print(currNode.getValue());
            helperPre(currNode.getLeftChild());
            helperPre(currNode.getRightChild());
        }
        return output +=  currNode.getValue();
    }

    /**
     * calls helperpost
     */
    public void printPostorder(){
        helperPost(root);
    }

    /**
     * travereses to the bottom left of the tree and prints that node then traverses the right subtree and then the parent
     * @param currNode the node bing checked
     * @return all nodes in the order of the pattern
     */
    public String helperPost(TreeNode currNode){
        if (currNode == null) {
            return null;
        } else {
            helperPost(currNode.getLeftChild());
            helperPost(currNode.getRightChild());
            System.out.print(currNode.getValue());
        }
        return output += currNode.getValue();
    }

    public <E> E delete(E value) {
        if (root == null) {
            return null;
        }
        TreeNode currNode = root;
        while (!(currNode.getLeftChild() == null) && !(currNode.getRightChild() == null)) {
            if (currNode.getValue().compareTo(value) == 1){
                currNode = currNode.getLeftChild();
            }
            else if (currNode.getValue().compareTo(value) < 1) {
                currNode = currNode.getRightChild();
            }
        }
    }
}
