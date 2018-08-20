package btreeconstruction;

import java.util.Scanner;
import java.lang.*;

public class BTreeConstruction {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        ConstructionQuestion tree = new ConstructionQuestion();
        ConstructionQuestion2 con = new ConstructionQuestion2();
       
        do{
            System.out.print("\n1)Create tree using inorder and preorder\n"
                    + "2)Create tree from linlist\n3)Create tree from array"
                    + "\n4)Convert tree to DLL\n5)Convert a given tree to its Sum Tree\n"
                    + "6)Convert tree to Circular DLL\n7)Create a Doubly Linked "
                    + "List from a Ternary Tree\n8)Construct Full Binary Tree "
                    + "from given preorder and postorder traversals\n"
                    + "9)Binary tree to a tree that holds Logical AND property\n"
                    + "10)Binary Tree into Doubly Linked List in spiral fashion\n"
                    + "11)Mirror Tree\n12)Ternary Expression to a Binary Tree\n"
                    + "13)Flip Binary Tree\n"+"14)every node stores sum of all"
                    + " nodes in left subtree\n15)Tree from Inorder and Level "
                    + "order traversal\n16)Tree from preorder and postorder traversal\n"
                    + "17)special tree from given preorder traversal\n"
                    + "18)Binary Tree from given Inorder traversal\n"
                    + "19)Binary Tree from given PostOredre and Inorder traversal\n"
                    + "20)Creating a tree with Left-Child Right-Sibling Representation\n"
                    + "21)k-ary tree from its preorder traversal\n"
                    + "22)Tree from String with bracket representation\n"
                    + "23)Convert left-right representation of a binary tree to down-right\n"
                    + "24)Tree that holds Children Sum Property\n"
                    + "25)Tree using its Preorder traversal and Preorder traversal of its mirror tree\n"
                            + "30)Exit");
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
                        
                case 11:System.out.print("\nNumber of nodes:-");
                        num=sc.nextInt();
                        for(int i=0;i<num;i++){
                            System.out.print("\nValue:-");
                            int value = sc.nextInt();
                            tree.createBT(value);
                        }
                        tree.mirrorTree(tree.getRootData());
                        System.out.print("\nPrinting mirror tree...");
                        tree.inorder(tree.getRootData());
                        break;
                        
                case 12:String exp = "a?b?c:d:e";
                        char[] expression = exp.toCharArray();
                        CharNode charNode=tree.ternaryToTree(expression,0);
                        tree.printTernary(charNode);
                        break;
                        
                case 13:System.out.print("\nNumber of nodes:-");
                        num=sc.nextInt();
                        for(int i=0;i<num;i++){
                            System.out.print("\nValue:-");
                            int value = sc.nextInt();
                            tree.createBT(value);
                        }
                        System.out.print("\nBefore flip....\n");
                        tree.inorder(tree.getRootData());
                        System.out.print("\nAfter flip...\n");
                        tree.flipBinaryTree(tree.getRootData());
                        tree.inorder(tree.getRootData());
                        break;
                        
                case 14:System.out.print("\nNumber of nodes:-");
                        num=sc.nextInt();
                        for(int i=0;i<num;i++){
                            System.out.print("\nValue:-");
                            int value = sc.nextInt();
                            tree.createBT(value);
                        }
                        System.out.print("\nBefor update.....\n");
                        tree.inorder(tree.getRootData());
                        tree.updateTree(tree.getRootData());
                        System.out.print("\nAfter update.....\n");
                        tree.inorder(tree.getRootData());
                        break;
                        
                case 15:int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
                        int level[] = new int[]{20, 8, 22, 4, 12, 10, 14};
                        TreeUsingOrder startNode=null;
                        startNode=con.treeUsingInAndLevel(startNode,level,in,0,in.length-1);
                        con.printInorder(startNode);
                        break;
                        
                case 16:int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
                        int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
                        startNode=null;
                        startNode=con.treeUsingPreAndPost(pre,post,0,pre.length-1,pre.length);
                        con.printInorder(startNode);
                        break;
                        
                case 17:int preOrder[] = new int[]{10, 30, 20, 5, 15};
                        char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'};
                        int len=preOrder.length;
                        startNode=null;
                        Index n = new Index();
                        startNode=con.specialTree(preOrder, preLN,n, len, startNode);
                        con.printInorder(startNode);
                        break;
                        
                case 18:int inOrder[]=new int[]{5, 10, 40, 30, 28};
                        len=inOrder.length;
                        startNode=null;
                        startNode=con.treeUsingInorder(inOrder, 0, len-1, startNode);
                        con.printInorder(startNode);
                        break;
                        
                case 19:int inOrderList[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
                        int postOrder[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
                        len=inOrderList.length;
                        startNode=null;
                        Index index=new Index();
                        index.index=len-1;
                        startNode=con.treeUsingPostAndIn(inOrderList, postOrder, 0, len-1, index);
                        con.printInorder(startNode);
                        break;
                        
                case 20:NodeTemp root = new NodeTemp(10);
                        NodeTemp n1 = con.addChild(root,2);
                        NodeTemp n2 = con.addChild(root,3);
                        NodeTemp n3 = con.addChild(root,4);
                        NodeTemp n4 = con.addChild(n3,6);
                        NodeTemp n5 = con.addChild(root,5);
                        NodeTemp n6 = con.addChild(n5,7);
                        NodeTemp n7 = con.addChild(n5,8);
                        NodeTemp n8 = con.addChild(n5,9);
                        con.traverseTree(root);
                        break;
                        
                case 21:int ind = 0;
                        int k = 3; num = 10;
                        int preOrderList[] = { 1, 2, 5, 6, 7, 3, 8, 9, 10, 4 };
                        int treeHeight = (int)Math.ceil(Math.log((double)num * (k - 1) + 1)/ Math.log((double)k));
                        KRootNode rootNode= con.buildKrootTree(preOrderList,num,k,treeHeight,ind);
                        con.postord(rootNode, k);
                        break;
                        
                case 22:String str = "4(2(3)(1))(6(5))";
                        startNode=null;
                        char[] strData=str.toCharArray();
                        startNode=con.treeFromString(strData, 0, str.length()-1);
                        con.printInorder(startNode);
                        break;
                        
                case 23:startNode=null;
                        startNode = new TreeUsingOrder(1);
                        startNode.left = new TreeUsingOrder(2);
                        startNode.right = new TreeUsingOrder(3);
                        startNode.right.left = new TreeUsingOrder(4);
                        startNode.right.right = new TreeUsingOrder(5);
                        startNode.right.right.left = new TreeUsingOrder(7);
                        startNode.right.left.left = new TreeUsingOrder(6);
                        startNode.right.right.right = new TreeUsingOrder(8);
                        con.convertTree(startNode);
                        con.printInorder(startNode);
                        break;
                        
                case 24:startNode=null;
                        startNode = new TreeUsingOrder(1);
                        startNode.left = new TreeUsingOrder(2);
                        startNode.right = new TreeUsingOrder(3);
                        startNode.right.left = new TreeUsingOrder(4);
                        startNode.right.right = new TreeUsingOrder(5);
                        startNode.right.right.left = new TreeUsingOrder(7);
                        startNode.right.left.left = new TreeUsingOrder(6);
                        startNode.right.right.right = new TreeUsingOrder(8);
                        System.out.print("\nTree before converstion..\n");
                        con.printInorder(startNode);
                        con.treeToHoldSum(startNode);
                        System.out.print("\nAfter convrsion..\n");
                        con.printInorder(startNode);
                        break;
                        
                case 25:int preOrderArray[] = {1,2,4,5,3,6,7};
                        int preOrderMirror[] = {1,3,7,6,2,5,4};
                        int size = preOrderArray.length;
                        startNode=null;
                        startNode=con.treeUsingPreAndMirror(preOrderArray,
                                preOrderMirror,0,0,size-1,size);
                        con.printInorder(startNode);
                        break;
            }
        }while(choice!=30);
    }
}
