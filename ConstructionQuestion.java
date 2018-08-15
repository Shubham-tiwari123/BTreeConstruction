package btreeconstruction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Stack;

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

class LinkNode{
    int data;
    LinkNode prev;
    LinkNode next;
}

class CharNode{
    char data;
    CharNode left;
    CharNode right;

    public CharNode(char item) {
        data = item;
        left = null;
        right = null;
    }
}

class TernaryTree{
    int data;
    TernaryTree left;
    TernaryTree right;
    TernaryTree middle;
    
    public TernaryTree(int data){
        this.data = data;
        left=right=middle=null;
    }
}
public class ConstructionQuestion {
    
    Queue<Integer> queueList = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    
    Node root,temp,newnode,temp1=null;
    IntNode rootNode,newNode,tempNode,tempNode1=null;
    LinkNode listRoot,tempListNode,newListNode;
    int ArrayList[] = new int[10];
    int ternaryList[] = new int[13];
    
    public ConstructionQuestion(){
        root = null;
        rootNode=null;
        listRoot=null;
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
    
    public void createArray(int num){
        for(int i=0;i<num;i++){
            System.out.print("\nData:-");
            int data=scanner.nextInt();
            ArrayList[i]=data;
        }
    }
    
    void treeFromArrayList(int num){
        
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        
        queue.add(ArrayList[0]);
        queue2.add(ArrayList[1]);
        queue2.add(ArrayList[2]);
        
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
                    queue2.add(ArrayList[j]);
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
    
    public void createBT(int value){
        int num;
        char side;
        int flag1=0,flag2=0;
            
        newNode = new IntNode();
        newNode.data = value;
        newNode.left=null;
        newNode.right=null;
            
        if(rootNode==null){
            rootNode = newNode;
        }
        else{
            tempNode = rootNode;
            System.out.print("\nWhere to enter(L/R):-");
            side=scanner.next().charAt(0);
            if(side=='L'){
                if(tempNode.left==null){
                    tempNode.left = newNode;
                    tempNode=null;
                }
                else{
                    tempNode=tempNode.left;
                }
                while(tempNode!=null){
                    System.out.print("\nWhere to enter(L/R):-");
                    side=scanner.next().charAt(0);
                    if(side=='L'){
                        tempNode1 = tempNode;
                        tempNode=tempNode.left;
                        flag1=1;
                        flag2=0;
                    }
                    else{
                        tempNode1=tempNode;
                        tempNode=tempNode.right;
                        flag1=0;
                        flag2=1;
                    }
                }
                if(flag1==1)
                    tempNode1.left=newNode;
                else if(flag2==1)
                    tempNode1.right=newNode;
            }
            else{
                if(rootNode.right==null){
                    rootNode.right = newNode;
                    tempNode = null;
                }
                else{
                    tempNode=tempNode.right;
                }
                while(tempNode!=null){
                    System.out.print("\nWhere to enter(L/R):-");
                    side=scanner.next().charAt(0);
                    if(side=='L'){
                        tempNode1 = tempNode;
                        tempNode=tempNode.left;
                        flag1=1;
                        flag2=0;
                    }
                    else{
                        tempNode1=tempNode;
                        tempNode=tempNode.right;
                        flag1=0;
                        flag2=1;
                    }
                }
                if(flag1==1)
                    tempNode1.left=newNode;
                else if(flag2==1)
                    tempNode1.right=newNode;
            }

        }
    }
    
    public void saveData(IntNode nodeData){
        if(nodeData==null)
            return;
        saveData(nodeData.left);
        queueList.add(nodeData.data);
        saveData(nodeData.right);
    }
    void convertTreetoDll(){
        saveData(rootNode);
        while(!queueList.isEmpty()){
            newListNode = new LinkNode();
            newListNode.data = queueList.poll();
            newListNode.next=null;
            newListNode.prev=null;

            if(listRoot==null)
                listRoot=newListNode;
            else{
                tempListNode=listRoot;
                while(tempListNode.next!=null)
                    tempListNode=tempListNode.next;
                tempListNode.next=newListNode;
                newListNode.prev=tempListNode;
            }
        }
        tempListNode=listRoot;
        System.out.print("\nPrinting tree in Dll.....\n");
        while(tempListNode!=null){
            System.out.print(tempListNode.data+" ");
            tempListNode=tempListNode.next;
        }
    }
    
    int convertTreeToSum(IntNode nodeData){
        if(nodeData==null)
            return 0;
        int old_value = nodeData.data;
        nodeData.data=convertTreeToSum(nodeData.left)+convertTreeToSum(nodeData.right);
        return nodeData.data+old_value;
    }
    
    IntNode getRootData(){
        return rootNode;
    }
    
    void convertTreeToCircularDLL(){
        saveData(rootNode);
        while(!queueList.isEmpty()){
            newListNode = new LinkNode();
            newListNode.data = queueList.poll();
            newListNode.next=newListNode;
            newListNode.prev=newListNode;

            if(listRoot==null)
                listRoot=newListNode;
            else{
                tempListNode=listRoot.prev;
                newListNode.next=listRoot;
                listRoot.prev=newListNode;
                newListNode.prev=tempListNode;
                tempListNode.next=newListNode;
            }
        }
        tempListNode=listRoot;
        System.out.print("\nPrinting tree in Circular Dll.....\n");
        do{
            System.out.print(tempListNode.data+" ");
            tempListNode=tempListNode.next;
        }while(tempListNode!=listRoot);
    }
    
    void storeDataLevelOrder(TernaryTree node){
        int i=0;
        TernaryTree tempVar;
        Queue<TernaryTree> queue = new LinkedList<>();
        queue.add(node);
        System.out.print("\n");
        while(!queue.isEmpty()){
            tempVar = queue.poll();
            
            if(tempVar.left!=null)
                queue.add(tempVar.left);
            
            if(tempVar.middle!=null)
                queue.add(tempVar.middle);
            
            if(tempVar.right!=null)
                queue.add(tempVar.right);
            ternaryList[i]=tempVar.data;
            i++;
        }
    }
    
    void createDLL(){
        int j,k=0,count=0;
        newListNode = new LinkNode();
        newListNode.data = ternaryList[0];
        newListNode.next=null;
        newListNode.prev=null;
        if(listRoot==null)
            listRoot=newListNode;
        
        for(int i=1;i<=3;i++){
            newListNode = new LinkNode();
            newListNode.data = ternaryList[i];
            newListNode.next=null;
            newListNode.prev=null;
            tempListNode = listRoot;
            while(tempListNode.next!=null)
                tempListNode=tempListNode.next;
            tempListNode.next=newListNode;
            newListNode.prev=tempListNode;
            if(i==1)
                k=i+3;
            for(j=0;j<3;j++){
                newListNode = new LinkNode();
                newListNode.data = ternaryList[k];
                newListNode.next=null;
                newListNode.prev=null;
                tempListNode = listRoot;
                while(tempListNode.next!=null)
                    tempListNode=tempListNode.next;
                tempListNode.next=newListNode;
                newListNode.prev=tempListNode;
                k=k+1;
            }
            
        }
        
        tempListNode=listRoot;
        System.out.print("\nPrinting tree in Dll.....\n");
        while(tempListNode!=null){
            System.out.print(tempListNode.data+" ");
            tempListNode=tempListNode.next;
        }
    }
    
    /*void treeUsingPostAndPre(int pre[], int post[], int size){
        int flag1[] = new int[size];
        int flag2[] = new int[size];
        int l=0;
        int h=size-1;
        if(rootNode == null){
            newNode=new IntNode();
            newNode.data=pre[0];
            //System.out.println(pre[0]+"pre1 ");
            newNode.left=null;
            newNode.right=null;
            rootNode=newNode;
            for(int i=0;i<size;i++){
                if(post[i]==pre[0]){
                    flag1[i]=1;
                    break;
                }
            }
        }
        if(rootNode.left==null){
            newNode=new IntNode();
            newNode.data=pre[1];
            //System.out.println(pre[1]+"pre2");
            newNode.left=null;
            newNode.right=null;
            rootNode.left=newNode;
            for(int i=0;i<size;i++){
                if(post[i]==pre[1]){
                    flag1[i]=1;
                    break;
                }
            }
        }
        if(rootNode.right==null){
            newNode=new IntNode();
            newNode.data=post[size-2];
            //System.out.println(post[size-2]+"post1");
            newNode.left=null;
            newNode.right=null;
            rootNode.right=newNode;
            for(int i=0;i<size;i++){
                if(pre[i]==post[size-2]){
                    flag2[i]=1;
                    break;
                }
            }
        }
        else{
            for(int i=2;i<size;i++){
                if(flag2[i]!=1){
                    
                }
            }
        }
        inorder(rootNode);
    }*/
    
    void convertToLogicalAND(IntNode node){
        if(node == null)
            return;
        convertToLogicalAND(node.left);
        convertToLogicalAND(node.right);
        if(node.left!=null && node.right!=null)
            node.data= (node.left.data) & (node.right.data);
    }
    
    void printSpiral(IntNode node) {
        Stack<IntNode> s1 = new Stack<>();
        Queue<IntNode> q= new LinkedList<>();
        Stack<IntNode> s2 = new Stack<>();
        s1.push(node);
        System.out.print("\n");
        while(!s1.isEmpty()||!s2.isEmpty()){
            while(!s1.isEmpty()){
                tempNode = s1.pop();
                if(tempNode.right!=null)
                    s2.push(tempNode.right);
                if(tempNode.left!=null)
                    s2.push(tempNode.left);
                q.add(tempNode);
            }
            while(!s2.isEmpty()){
                tempNode = s2.pop();
                if(tempNode.left!=null)
                    s1.push(tempNode.left);
                if(tempNode.right!=null)
                    s1.push(tempNode.right);
                q.add(tempNode);
            }
        }
        
        rootNode=q.poll();
        rootNode.left=null;
        rootNode.right=null;
        while(!q.isEmpty()){
            newNode = q.poll();
            if(rootNode.right==null){
                rootNode.right=newNode;
                newNode.left=rootNode;
                newNode.right=null;
            }
            else{
                tempNode = rootNode;
                while(tempNode.right!=null)
                    tempNode=tempNode.right;
                tempNode.right=newNode;
                newNode.left=tempNode;
                newNode.right=null;
            }
        }
        System.out.print("\nConverting the tree to DLL without creating new space");
        tempNode=rootNode;
        while(tempNode!=null){
            System.out.print(tempNode.data+" ");
            tempNode=tempNode.right;
        }
    }
    
    IntNode mirrorTree(IntNode node){
        if(node==null)
            return node;
        IntNode left=mirrorTree(node.left);
        IntNode right=mirrorTree(node.right);
        
        node.left=right;
        node.right=left;
        
        return node;
    }
    
    CharNode ternaryToTree(char[] expression,int i){
        if(i>=expression.length)
            return null;
        
        CharNode charNode = new CharNode(expression[i]);
        ++i;
        if (i<expression.length && expression[i]=='?')
            charNode.left = ternaryToTree(expression, i+1);
        
        else if (i < expression.length)
            charNode.right = ternaryToTree(expression, i+1);
      
        return charNode;
    }
    
    void printTernary(CharNode charNode){
        if(charNode==null)
            return;
        System.out.print(charNode.data+" ");
        printTernary(charNode.left);
        printTernary(charNode.right);
    }
    
    IntNode flipBinaryTree(IntNode node){
        if(node==null)
            return node;
        if(node.left==null&&node.right==null)
            return node;
        rootNode = flipBinaryTree(node.left);
        
        node.left.left=node.right;
        node.left.right=node;
        node.left=node.right=null;
        return rootNode;
    }
    
    int updateTree(IntNode node){
        if(node==null)
            return 0;
        if(node.left==null && node.right==null)
            return node.data;
        int leftsum=updateTree(node.left);
        int rightsum=updateTree(node.right);
        node.data=node.data+leftsum;
        return node.data;
    }
}
