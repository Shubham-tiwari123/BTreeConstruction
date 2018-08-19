package btreeconstruction;
import java.util.Vector;
import java.util.Stack;
class TreeUsingOrder{
    int data;
    TreeUsingOrder left;
    TreeUsingOrder right;

    public TreeUsingOrder(int item) {
        data=item;
        left=right=null;
    }
}

class NodeTemp{
    int data;
    NodeTemp next,child;
    
    public NodeTemp(int data) {
        this.data=data;
        next=child=null;
    }
    
}

class KRootNode{
    int data;
    Vector<KRootNode> child = new Vector<>();

    public KRootNode(int data) {
        data=this.data;
    }
    
}

class Index {
    int index = 0;
}
public class ConstructionQuestion2 {
    int preIndex=0;
    
    TreeUsingOrder treeUsingInAndLevel(TreeUsingOrder startNode,int[] levelOrder,
            int[] inOrder,int inStart,int inEnd){
        if(inStart>inEnd)
            return null;
        if(inStart==inEnd)
            return new TreeUsingOrder(inOrder[inStart]);
        boolean found = false;
        int index = 0;
  
        for (int i = 0; i < levelOrder.length - 1; i++) 
        {
            int data = levelOrder[i];
            for (int j = inStart; j < inEnd; j++) 
            {
                if (data == inOrder[j]) 
                {
                    startNode = new TreeUsingOrder(data);
                    index = j;
                    found = true;
                    break;
                }
            }
            if (found == true)
                break;
        }
  
        startNode.left=treeUsingInAndLevel(startNode, levelOrder, inOrder, 
                                                    inStart, index - 1);
        startNode.right=treeUsingInAndLevel(startNode, levelOrder, inOrder, 
                                                     index + 1, inEnd);
  
        return startNode;
    }
    void printInorder(TreeUsingOrder node) 
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
    
    TreeUsingOrder treeUsingPreAndPost(int pre[], int post[], int l,int h, int size){
        
        if (preIndex >= size || l > h)
           return null;
        TreeUsingOrder root = new TreeUsingOrder(pre[preIndex]);
        preIndex++;
        if (l == h || preIndex >= size)
            return root;
        int i;
        for (i = l; i <= h; i++){
            if (post[i] == pre[preIndex])
                break;
        }
        if (i <= h){
            root.left = treeUsingPreAndPost(pre, post, l, i, size);
            root.right = treeUsingPreAndPost(pre, post, i + 1, h, size);
        }
        return root;
    }
    
    TreeUsingOrder specialTree(int pre[], char preLN[], Index index_ptr,int n, TreeUsingOrder temp){
        int index=index_ptr.index;
        if (index == n)
            return null;
        temp = new TreeUsingOrder(pre[index]);
        (index_ptr.index)++;
        if (preLN[index] == 'N') {
            temp.left = specialTree(pre, preLN, index_ptr, n, temp.left);
            temp.right = specialTree(pre, preLN, index_ptr, n,temp.right);
        }
  
        return temp;
    }
    
    TreeUsingOrder treeUsingInorder(int inorder[], int start, int end, TreeUsingOrder node){
        if (start > end)
            return null;
        int i = max(inorder, start, end);
        node = new TreeUsingOrder(inorder[i]);
        if (start == end)
            return node;
        node.left = treeUsingInorder(inorder, start, i - 1, node.left);
        node.right = treeUsingInorder(inorder, i + 1, end, node.right);
  
        return node;
    }
    int max(int arr[], int strt, int end){
        int i, max = arr[strt], maxind = strt;
        for (i = strt + 1; i <= end; i++){
            if (arr[i] > max){
                max = arr[i];
                maxind = i;
            }
        }
        return maxind;
    }
    TreeUsingOrder treeUsingPostAndIn(int in[], int post[], int inStrt,int inEnd,
            Index pIndex){
        if (inStrt > inEnd)
            return null;
        TreeUsingOrder startNode = new TreeUsingOrder(post[pIndex.index]);
        (pIndex.index)--;
        if (inStrt == inEnd)
            return startNode;
        int iIndex = search(in, inStrt, inEnd, startNode.data);
        startNode.right = treeUsingPostAndIn(in, post, iIndex + 1, inEnd, pIndex);
        startNode.left = treeUsingPostAndIn(in, post, inStrt, iIndex - 1, pIndex);
 
        return startNode;
    }
    int search(int arr[], int strt, int end, int value){
        int i;
        for (i = strt; i <= end; i++){
            if (arr[i] == value)
                break;
        }
        return i;
    }
    public NodeTemp addChild(NodeTemp node,int data){
        if(node == null)
            return null;
        if(node.child != null)
            return(addSibling(node.child,data));
        else
            return(node.child = new NodeTemp(data));
    } 
    public NodeTemp addSibling(NodeTemp node, int data){
        if(node == null)
            return null;
        while(node.next != null)
            node = node.next;
        return(node.next = new NodeTemp(data));
    }
    public void traverseTree(NodeTemp root){
        if(root == null)
            return;
        while(root != null){
            System.out.print(root.data + " ");
            if(root.child != null)
                traverseTree(root.child);
            root = root.next;
        }
    }
    KRootNode buildKrootTree(int A[],int n,int k,int h,int ind){
        if (n <= 0)
        return null;
        KRootNode nNode = new KRootNode(A[ind]);
        if (nNode == null) {
            return null;
        }
        for (int i = 0; i < k; i++) {
            if (ind < n - 1 && h > 1) {
                ind++;
                nNode.child.add(buildKrootTree(A, n, k, h, ind));
            } else {
                nNode.child.add(null);
            }
        }
        return nNode;
    }
    void postord(KRootNode root, int k){
        if (root == null)
            return;
        for (int i = 0; i < k; i++)
            postord(root.child.elementAt(i),k);
        System.out.println(root.data+" ");
    }
    int findIndex(char[] str, int si, int ei)
{
    if (si > ei)
        return -1;
    Stack<Character>s = new Stack<>();
 
    for (int i = si; i <= ei; i++) {
        if (str[i] == '(')
            s.add(str[i]);
        else if (str[i] == ')') {
            if (s.firstElement() == '(') {
                s.pop();
                if (s.empty())
                    return i;
            }
        }
    }
    return -1;
}
    TreeUsingOrder treeFromString(char[] str,int start,int end){
        if(start>end)
            return null;
        TreeUsingOrder startNode=new TreeUsingOrder(str[start]-'0');
        int index=-1;
        
        if ((start+1)<= end && str[start+1] == '(')
             index = findIndex(str, start + 1, end);
         if (index != -1) {
        startNode.left = treeFromString(str, start + 2, index - 1);
        startNode.right = treeFromString(str, index + 2, end - 1);
    }
    return startNode;
    }
}
