public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.add(5);
        tree.add(9);
        tree.add(1);
        tree.add(7);
        tree.add(11);
        tree.add(0);
        tree.contains(0);
        System.out.println(tree.getHeight());
        tree.printInorder();
        System.out.print("\n");
        tree.printPostorder();
        System.out.print("\n");
        tree.printPreorder();
        System.out.print("\n");
        System.out.print(tree.countLeafNodes() + "\n");
        System.out.print(tree.countNodes());
        tree.delete(0);
        tree.printPreorder();
    }
}