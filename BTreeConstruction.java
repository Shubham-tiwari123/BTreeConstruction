package btreeconstruction;

import java.util.Scanner;

public class BTreeConstruction {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        ConstructionQuestion tree = new ConstructionQuestion();
       
        do{
            System.out.print("\n1)Create tree using inorder and preorder:-\n"
                    + "2)Create tree in levelOrder using array:-\n12)Exit");
            System.out.print("\nEnter your choice:-");
            choice=sc.nextInt();
            switch(choice){
                case 1: char inorder[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
                        char preorder[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
                        tree.buildTree(inorder,preorder);
                        tree.printInorder(tree.getRoot());
                        break;
                        
                case 2: System.out.print("\nEnter number of nodes to create list:-");
                        int num=sc.nextInt();
                        tree.createList(num);
                        tree.treeFromLinkList();
                        break;
                case 3:
                       break;
            }
        }while(choice!=12);
    }
    
}
