package Sintatico.AST;

public class Tree {

    Node root;

    public Tree (Node root){
        this.root = root;
    }

    public void simpleWalk (Node node){
        System.out.println(" " + node.data + " ");

        for (Node child: node.getChildren()) {
            simpleWalk(child);
        }
    }

    public void walk(Node node){
        System.out.println(node.enter);
        if (node.isLeaf())
            System.out.println(" " + node.data + " ");
        for (Node child: node.getChildren())
            walk(child);

        System.out.println(node.exit);
    }


}