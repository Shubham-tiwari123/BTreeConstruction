package btreeconstruction;

class TreeUsingOrder{
    int data;
    TreeUsingOrder left;
    TreeUsingOrder right;

    public TreeUsingOrder(int item) {
        data=item;
        left=right=null;
    }
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
}
