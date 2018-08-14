package btreeconstruction;

import java.util.Scanner;

public class BTreeConstruction {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        ConstructionQuestion tree = new ConstructionQuestion();
       
        do{
            System.out.print("\n1)Create tree using inorder and preorder\n"
                    + "2)Create tree from linlist\n3)Create tree from array"
                    + "\n4)Convert tree to DLL\n5)Convert a given tree to its Sum Tree\n"
                    + "6)Convert tree to Circular DLL\n7)Create a Doubly Linked "
                    + "List from a Ternary Tree\n8)Construct Full Binary Tree "
                    + "from given preorder and postorder traversals\n"
                    + "9)Binary tree to a tree that holds Logical AND property\n"
                    + "10)Binary Tree into Doubly Linked List in spiral fashion\n"
                    + "12)Exit");
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

                case 3: System.out.print("\nEnter number of nodes to create list:-");
                        num=sc.nextInt();
                        tree.createArray(num);
                        tree.treeFromArrayList(num);
                        break;

                case 4: 
                        System.out.print("\nNumber of nodes:-");
                        num=sc.nextInt();
                        for(int i=0;i<num;i++){
                            System.out.print("\nValue:-");
                            int value = sc.nextInt();
                            tree.createBT(value);
                        }
                        tree.convertTreetoDll();
                        break;

                case 5: System.out.print("\nNumber of nodes:-");
                        num=sc.nextInt();
                        for(int i=0;i<num;i++){
                            System.out.print("\nValue:-");
                            int value = sc.nextInt();
                            tree.createBT(value);
                        }
                        tree.inorder(tree.getRootData());
                        System.out.print("\nAfter conersion....\n");
                        tree.convertTreeToSum(tree.getRootData());
                        tree.inorder(tree.getRootData());
                        break;

                case 6: System.out.print("\nNumber of nodes:-");
                        num=sc.nextInt();
                        for(int i=0;i<num;i++){
                            System.out.print("\nValue:-");
                            int value = sc.nextInt();
                            tree.createBT(value);
                        }
                        tree.convertTreeToCircularDLL();
                        break;
                        
                case 7: System.out.print("\nCreating ternary tree....");
                        TernaryTree treeRoot = new TernaryTree(30);
                        treeRoot.left = new TernaryTree(5);
                        treeRoot.middle = new TernaryTree(11);
                        treeRoot.right = new TernaryTree(63);
                        treeRoot.left.left = new TernaryTree(1);
                        treeRoot.left.middle = new TernaryTree(4);
                        treeRoot.left.right = new TernaryTree(8);
                        treeRoot.middle.left = new TernaryTree(6);
                        treeRoot.middle.middle = new TernaryTree(7);
                        treeRoot.middle.right = new TernaryTree(15);
                        treeRoot.right.left = new TernaryTree(31);
                        treeRoot.right.middle = new TernaryTree(55);
                        treeRoot.right.right = new TernaryTree(65);
                        tree.storeDataLevelOrder(treeRoot);
                        tree.createDLL();
                        break;
                        
                case 8: /*int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7};
                        int post[] ={ 8, 9, 4, 5, 2, 6, 7, 3, 1};
                        int size = pre.length;
                        tree.treeUsingPostAndPre(pre, post, size);*/
                        break;
                        
                case 9: System.out.print("\nNumber of nodes:-");
                        num=sc.nextInt();
                        for(int i=0;i<num;i++){
                            System.out.print("\nValue:-");
                            int value = sc.nextInt();
                            tree.createBT(value);
                        }
                        tree.convertToLogicalAND(tree.getRootData());
                        tree.inorder(tree.getRootData());
                        break;
                        
                case 10:System.out.print("\nNumber of nodes:-");
                        num=sc.nextInt();
                        for(int i=0;i<num;i++){
                            System.out.print("\nValue:-");
                            int value = sc.nextInt();
                            tree.createBT(value);
                        }
                        tree.printSpiral(tree.getRootData());
                        break;
            }
        }while(choice!=12);
    }
    
}
