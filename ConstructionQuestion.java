package btreeconstruction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Iterator;

class Node{
    char data;
    Node left;
    Node right;
}

class IntNode{
    int data;
    IntNode left;
    IntNode right;
}
public class ConstructionQuestion {
    
    LinkedList<Integer> list = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    Node root,temp,newnode;
    IntNode rootNode;
    IntNode newNode,tempNode,tempNode1=null;
    Node temp1=null;
    
    public ConstructionQuestion(){
        root = null;
        rootNode=null;
    }
    
    public void buildTree(char inorder[],char preorder[]){
        int start=-1;
        int rootIndex=0;
        int index=0,i;
        char a;
        boolean flag=false;
        while(start<inorder.length-1){
            start++;
            a=preorder[start];
            if(root==null){
                create(a);
                for (i=0;i<inorder.length;i++){
                    if(inorder[i]==a){
                        inorder[i]='1';
                        break;
                    }
                }
                rootIndex = i;
                flag=true;
            }
            else{
                for (i=0;i<inorder.length;i++){
                    if(inorder[i]==a){
                        inorder[i]='1';
                        break;
                    }
                }
                if(flag){
                    if(i<rootIndex){
                        createLeft(a,0);
                    }
                    else{
                        createRight(a,0);
                    }
                    index=i;
                    flag=false;
                }
                else{
                    if(i<rootIndex&&i<=index){
                        createLeft(a,0);
                    }
                    else if(i>rootIndex&&i>=index){
                        createRight(a,0);
                    }
                    else if(i<rootIndex&&i>=index){
                        search(preorder[i]);
                        createRight(a,1);
                    }
                    else if(i>rootIndex&&i<=index){
                        search(preorder[i]);
                        createLeft(a,1);
                    }
                    index=i;
                }
            }
        }
    }
    public void search(char a){
        Queue<Node> queue = new LinkedList<>();
        temp=root;
        queue.add(temp);
        while(!queue.isEmpty()){
            temp = queue.poll();
            char b =temp.data;
            if(b==a){
                temp1 = temp;
                break;            
            }
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
    }
    public void create(char a){
        newnode = new Node();
        newnode.data = a;
        newnode.left=null;
        newnode.right=null;
        root=newnode;
    }
    public void createLeft(char a,int num){
        newnode = new Node();
        newnode.data = a;
        newnode.left=null;
        newnode.right=null;
        if(num==0){
            temp=root;
            while(temp.left!=null)
                temp=temp.left;
            temp.left=newnode;
        }
        else if(num==1){
            temp1.left=newnode;
        }
    }
    public void createRight(char a,int num){
        newnode = new Node();
        newnode.data = a;
        newnode.left=null;
        newnode.right=null;
        if(num==0){
            temp=root;
            while(temp.right!=null)
                temp=temp.right;
            temp.right=newnode;
        }
        else if(num==1){
            temp1.right=newnode;
        }
    }
    public void printInorder(Node node){
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
    Node getRoot(){
        return root;
    }
    void createList(int num){
        for(int i=0;i<num;i++){
            System.out.print("\nData:-");
            int data=scanner.nextInt();
            list.push(data);
        }
    }
    void treeFromLinkList(){
        int num=list.size();
        
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        
        queue.add(list.removeFirst());
        queue2.add(list.removeFirst());
        queue2.add(list.removeFirst());
        
        newNode = new IntNode();
        newNode.data=0;
        newNode.left= null;
        newNode.right=null;
        
        if (rootNode==null){
            rootNode = new IntNode();
            rootNode.data=queue.element();
            rootNode.left= null;
            rootNode.right=null;
            tempNode=rootNode;
            
            if(tempNode.left==null){
                newNode = new IntNode();
                newNode.data=queue2.element();
                newNode.left= null;
                newNode.right=null;
                tempNode.left=newNode;
                queue.poll();
                queue.add(queue2.poll());
            }
            if(tempNode.right==null){
                newNode = new IntNode();
                newNode.data=queue2.element();
                newNode.left= null;
                newNode.right=null;
                tempNode.right=newNode;
                queue.add(queue2.poll());
            }
        }
        int length=3,i,j=2;
        while(length<num){
            int queueLength = queue.size();
            for(i=0;i<(queue.size()*2);i++){
                j=j+1;
                if(j<num)
                    queue2.add(list.removeFirst());
            }
            length=length+1;
        }
        while(!queue2.isEmpty()){
            searchData(queue.element());
            queue.poll();
            if(!queue2.isEmpty()){
                newNode = new IntNode();
                newNode.data=queue2.element();
                newNode.left= null;
                newNode.right=null;
                tempNode1.left=newNode;
                queue.add(queue2.poll());
            }
            if(!queue2.isEmpty()){
                newNode = new IntNode();
                newNode.data=queue2.element();
                newNode.left= null;
                newNode.right=null;
                tempNode1.right=newNode;
                queue.add(queue2.poll());
            }
        }
        inorder(rootNode);
    }
    void searchData(int data){
        Queue<IntNode> queue3 = new LinkedList<>();
        Queue<IntNode> queue4 = new LinkedList<>();
        Iterator itr3=queue3.iterator();
        Iterator itr4=queue4.iterator();
        queue3.add(rootNode);
        
        while(itr3.hasNext()||itr4.hasNext()){
            while(itr3.hasNext()){
                if(queue3.element().left != null)
                    queue4.add(queue3.element().left);
                if(queue3.element().right != null)
                    queue4.add(queue3.element().right);
                if(data==queue3.element().data)
                    tempNode1=queue3.element();
                queue3.remove();
            }
            while(itr4.hasNext()){
                if(queue4.element().left != null)
                    queue3.add(queue4.element().left);
                if(queue4.element().right != null)
                    queue3.add(queue4.element().right);
                if(data==queue4.element().data)
                    tempNode1=queue4.element();
                queue4.remove();
            }
        }
    }
    public void inorder(IntNode node){
        if(node==null)
            return;
        inorder(node.left);
        System.out.print(node.data+"  ");
        inorder(node.right);
    }
    
}
