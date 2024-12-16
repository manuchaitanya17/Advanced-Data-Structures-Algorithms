//CHAPTER-1 TREE DATA STRUCTURE

//THEORY
//A. TREES- INTRODUCTION- RN
//B. TREE TERMINOLOGY- RN
//C. REPRESENTATION OF TREE DATA STRUCTURES- RN
//D. TYPES OF TREE DATA STRUCTURE- RN
//E. SPECIAL TYPES OF TREES IN DATA STRUTURES- RN

package com.company.Trees;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//F. IMPLEMENTATION OF BINARY TREES
//I. CREATION OF TREE CLASS
public class Main {

  // II. CREATION OF NODE CLASS, INSIDE TREE CLASS
  static class Node {

    // Three properties of nodes as we have discussed:
    int val;
    Node left;
    Node right;

    public Node(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }


  // II. CREATION OF CLASS, FOR INSERTION
  static class BinaryTreeInsertion {
    static int index = -1;


    // III. INSERTION OPERTAION-PREORDER INSERTION(TR+HR)
    public static Node buildTree(int nodes[]) {
      index++;
      if (nodes[index] == -1) {
        return null;
      }

      // Creation of Nodes while GO
      Node newnode = new Node(nodes[index]);

      // Storing References to left and right while COME
      newnode.left = buildTree(nodes);
      newnode.right = buildTree(nodes);
      return newnode;
    }
  }


  // IV. TRAVERSAL OPERATION-PREORDER(G/C/G--/C+ L/R + TR), DFS
  public static void preorderTraversal(Node temp, List<Integer> list) {
    if (temp == null) {
      return;
    }
    list.add(temp.val);
    preorderTraversal(temp.left, list);
    preorderTraversal(temp.right, list);

  }


  public static List<Integer> preorderTraversal(Node temp) {
    List<Integer> list = new ArrayList<>();
    preorderTraversal(temp, list);
    return list;
  }


  // V. TRAVERSAL OPERATION-INORDER(G/C/G--/C+ L/R + TR+HR), DFS
  public static void inOrder(Node temp) {
    if (temp == null) {
      return;
    }
    inOrder(temp.left);
    System.out.print(temp.val + " ");
    inOrder(temp.right);
  }
  /*
   * T1: INORDER MOVEMENT- LEFT SUBTREE->PARENT->RIGHT SUBTREE. It covers
   * last-left subtree, in the
   * given order. Mark the complete traversal as alpha moving to the next
   * parent(above). Covering
   * the parent move towards right.
   * 
   * 1
   * / \
   * 2 3
   * / \ / \
   * 4 5 6 7
   * Here the left-last subtree is 2-4-5. So, the inorder traversal is 4-2-5. Now
   * mark this as alpha.
   * 
   * 1
   * / \
   * α 3
   * / \
   * 6 7
   * Here as the left-subtree for 1 is covered now 1 is traversed. 4-2-5-1. Same
   * movement goes on right side.
   * Reaching a particular node ask it, is your left subtree is traversed or not.
   * If yes, then access it and
   * then move right.
   */


  // VI. TRAVERSAL OPERATION-POSTORDER, DFS
  public static void postOrder(Node temp) {
    if (temp == null) {
      return;
    }
    postOrder(temp.left);
    postOrder(temp.right);
    System.out.print(temp.val + " ");
  }


  // VII. LEVELORDER TRAVERSAL- USING QUEUE(BREADTH FIRST SEARCH))
  //Approach-1 TC-O(N) S-O(N/2)
  public static void levelOrder1(Node temp) {
    if (temp == null) {
      return;
    }

    // Step-1: Create a Queue DS
    Queue<Node> tS = new LinkedList<>();

    // Step-2: Add two objects inside it referring Root of the Tree and Null
    tS.add(temp);
    tS.add(null); // [1 , Null]

    while (!tS.isEmpty()) {

      // Step-3: Store reference of first in currentNode removing from the Queue
      Node currNode = tS.remove(); // [Null]

      if (currNode == null) {

        // Step-6(I): If currentNode = Null(Flag), then it means One Level has been
        // completed.

        System.out.println();
        if (tS.isEmpty()) {

          // Step-7: When all the level has been accessed then the Queue is empty. Break.
          break;
        }

        /*
         * Step-6(II): If the Queue is not empty then again add Null as all the element
         * of the next
         * Level has been already added to the Queue in Step-5. It will signify after
         * accessing next
         * level that the next level has also been completed.
         */

        else {
          tS.add(null); // [2, 3, Null]
        }
      }

      else {

        // Step-4: If the currNode is not Null, access the currentNode
        System.out.print(currNode.val + " ");

        // Step-5: Add the left and right of the currentNode to the Queue
        if (currNode.left != null) {
          tS.add(currNode.left);
        }
        if (currNode.right != null) {
          tS.add(currNode.right); // [Null, 2, 3]
        }
      }
    }
  }

  /* T1: BFS(BREADTH FIRST SEARCH)- When to use BFS in Tree DS:
     - When answer lies near Root.
     - When searching has to been done in levels.  */

  
  //Appraoch-2 TC-O(N) S-O(N/2)
  public static List<List<Integer>> levelOrder2(Node temp) {
    List<List<Integer>> ans = new ArrayList<>();
    if(temp==null){
      return ans;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(temp);

    while(!q.isEmpty()){
      int levelSize = q.size();
      List<Integer> level = new ArrayList<>();
      for(int i=0; i<levelSize; i++){
        TreeNode curr = q.poll();
        level.add(curr.val);
        if(curr.left!=null){
          q.offer(curr.left);
        }
        if(curr.right!=null){
          q.offer(curr.right);
        }
      }
      ans.add(level);
      
    }
    return ans;
  }


  // VIII. SEARCHING OPERATION
  public static boolean searching2(Node temp, boolean found2, int target2) {
    if (temp == null) {
      return false;
    }
    if (temp.val == target2) {
      return true;
    }
    return searching2(temp.left, found2, target2) || searching2(temp.right, found2, target2);
  }


// EXERCISES
// EXERCISE-1-RE

// EXERCISE-2

  // QUESTION-1 Binary Tree Level Order Traversal
  // Source-https://leetcode.com/problems/binary-tree-level-order-traversal/description/
  
    public static List<List<Integer>> levelOrder(TreeNode temp) {
      
      //Step-1: Create a 2D-ArrayList
      List<List<Integer>> ans = new ArrayList<>();

      //Step-2: If the Tree is empty, return the ArrayList
      if(temp==null){
        return ans;
      }

      //Step-3: Create a Queue DS
      Queue<TreeNode> q = new LinkedList<>();

      //Step-4: Add the Root to the Queue
      q.offer(temp);

      //Step-5: Run a while loop till the Queue is not empty 
      while(!q.isEmpty()){

        /* Step-6: Store the size of the Queue in a variable to flag that
           this much element will be polled from the Queue */
        int levelSize = q.size();

        // Step-7: Create a List DS to store the values of the current level
        List<Integer> level = new ArrayList<>();

        //Step-8: Run a for loop till the levelSize
        for(int i=0; i<levelSize; i++){

          //Step-9: Store the reference of the first element of the Queue in a variable and polled it from the Queue
          TreeNode curr = q.poll();

          //Step-10: Add the value of the current Node to the List DS
          level.add(curr.val);

          //Step-11: If the current Node has left child, add it to the Queue
          if(curr.left!=null){
            q.offer(curr.left);
          }

          //Step-12: If the current Node has right child, add it to the Queue
          if(curr.right!=null){
            q.offer(curr.right);
          }
        }

        //Step-13: Add the List DS to the 2D-ArrayList
        ans.add(level);
      }

      //Step-14: Return the 2D-ArrayList
      return ans;
    }


  
  
  //QUESTION-2 Average of Levels in Binary Tree
  //Source-https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root==null){
        return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            double levelSum = 0; 
            for(int i=0; i<levelSize; i++){
                TreeNode curr = q.poll();
                levelSum = levelSum+curr.val;
                if(curr.left!=null){
                q.offer(curr.left);
                }
                if(curr.right!=null){
                q.offer(curr.right);
                }
            }
            ans.add(levelSum/levelSize);
        }
        return ans;
    }



  
  //QUESTION-3 Level Order Sucessor
  //Source-https://www.geeksforgeeks.org/level-order-successor-of-a-node-in-binary-tree/
  
    public int levelOrderSuccessor(TreeNode root, int n) {
        if(root==null){
        return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            boolean flag = false;
            int levelSize = q.size();
            for(int i=0; i<levelSize; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
               if(curr.val==n){
                  return q.peek().val;
               }
            }
        }
        return null;
    }


  

  //QUESTION-4 Zigzag Level Order Traversal
  //Source-https://leetcode.com/problems/zigzag-level-order-traversal/description/
  
  public static List<List<Integer>> zigZag(Node temp) {
      List<List<Integer>> ans = new ArrayList<>();

      if(temp==null){
          return ans;
      }

      Deque<Node> dq = new LinkedList<>();
      dq.offer(temp);
      int currentLevel = 0;

      while(!dq.isEmpty()){
          int levelSize = dq.size();
          List<Integer> level = new ArrayList<>();

          if(currentLevel%2==0){
              for(int i=0; i<levelSize; i++){
                  Node curr = dq.pollFirst();

                  level.add(curr.val);


                  if(curr.left!=null){
                      dq.offerLast(curr.left);
                  }
                  if(curr.right!=null){
                      dq.offerLast(curr.right);
                  }
              }
          }
          else{
              for(int i=0; i<levelSize; i++){
                  Node curr = dq.pollLast();

                  level.add(curr.val);
                  if(curr.right!=null){
                      dq.offerFirst(curr.right);
                  }
                  if(curr.left!=null){
                      dq.offerFirst(curr.left);
                  }
              }
          }
          currentLevel++;
          ans.add(level);
      }

      return ans;
  }




  //QUESTION-5 Binary Tree Level Order Traversal II
  //Source-https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

    public static List<List<Integer>> levelOrderBottom(TreeNode temp) {
      List<List<Integer>> ans = new ArrayList<>();
      if(temp==null){
        return ans;
      }
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(temp);
      while(!q.isEmpty()){
        int levelSize = q.size();
        List<Integer> level = new ArrayList<>();
        for(int i=0; i<levelSize; i++){
          TreeNode curr = q.poll();
          level.add(curr.val);
          if(curr.left!=null){
            q.offer(curr.left);
          }
          if(curr.right!=null){
            q.offer(curr.right);
          }
        }
        ans.add(0, level);
      }
      return ans;
    }
    


  
  //QUESTION-6 Populating Next Right Pointers in Each Node
  //Source-https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/




  //QUESTION-7 Binary Tree Right Side View
  //Source-https://leetcode.com/problems/binary-tree-right-side-view/description/

      public List<Integer> rightSideView(TreeNode root) {
          List<Integer> ans = new ArrayList<>();
          if(temp==null){
              return ans;
          }

          Queue<TreeNode> q = new LinkedList<>();
          q.offer(temp);
          while(!q.isEmpty()){
              int levelSize = q.size();
              for(int i=0; i<levelSize; i++){
                  TreeNode curr = q.poll();
                  if(curr.left!=null){
                      q.offer(curr.left);
                  }
                  if(curr.right!=null){
                      q.offer(curr.right);
                  }
              }
              ans.add(curr.val);
          }
          return ans;
      }




  //QUESTION-8 Cousins in Binary Tree
  //Source-https://leetcode.com/problems/cousins-in-binary-tree/description/

      public boolean isCousins(TreeNode root, int x, int y) {
         TreeNode xx = findNode(root, x);
         TreeNode yy = findNode(root, y);

         return (level(root, xx, 0) == level(root, yy, 0))  && !isSibling(root, xx, yy);
      }

      public TreeNode findNode(TreeNode root, int x){
          Queue<TreeNode> q = new LinkedList<>();
          q.offer(temp);
          while(!q.isEmpty()){
              int levelSize = q.size();
              for(int i=0; i<levelSize; i++){
                  TreeNode curr = q.poll();
                  if(curr.val == x){
                      return curr;
                  }
                  if(curr.left!=null){
                      q.offer(curr.left);
                  }
                  if(curr.right!=null){
                      q.offer(curr.right);
                  }
              }
          }
          return null;
      }

      public int level(TreeNode root, TreeNode x, int depth){
          Queue<TreeNode> q = new LinkedList<>();
          q.offer(temp);
          while(!q.isEmpty()){
              int levelSize = q.size();
              for(int i=0; i<levelSize; i++){
                  depth++;
                  TreeNode curr = q.poll();
                  if(curr.val == x){
                      break;
                  }
                  if(curr.left!=null){
                      q.offer(curr.left);
                  }
                  if(curr.right!=null){
                      q.offer(curr.right);
                  }
              }

          }
          return depth;
      }

      public boolean isSibling(TreeNode root, int x, int y){
          Queue<TreeNode> q = new LinkedList<>();
          q.offer(temp);
          while(!q.isEmpty()){
              int levelSize = q.size();
              for(int i=0; i<levelSize; i++){
                  boolean flag1 = false, flag2 = false;
                  TreeNode curr = q.poll();
                  if(curr.left!=null){
                      q.offer(curr.left);
                      if(curr.left.val == x || curr.left.val == y) {
                          flag1 = true;
                      }
                  }
                  if(curr.right!=null){
                      q.offer(curr.right);
                      if(curr.right.val == x || curr.right.val == y){
                          flag2 = true;
                      }
                  }
              }
          }
          return flag1 && flag2;
      }




     //QUETSION-9 Symmetric Tree
     //Source-https://leetcode.com/problems/symmetric-tree/description/

        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root.left);
            q.offer(root.right);

            while(!q.isEmpty()){
                TreeNode left = q.poll();
                TreeNode right = q.poll();

                if(left == null && right == null){
                    continue;
                }

                if(left == null || right ==null){
                    return false;
                }

                if(left.val != right.val){
                    return false;
                }

                q.offer(left.left);
                q.offer(right.right);
                q.offer(left.right);
                q.offer(right.left);
            }
            return true;
        }
        //T2: Tree-Edge Comparison- Traversing through the edges of tree.



//EXERCISE-3

      //QUESTION-1 Height of a Binary Tree
      //Source-https://leetcode.com/problems/height-of-binary-tree/description/

        //Approach-1 Pre-Order Traversal
        private static int helperheightOfBinaryTree1(BinaryTree.Node root, int height){
            if(root == null){
                return height;
            }
            height += 1;
            int LIRV = helperheightOfBinaryTree1(root.left, height);
            int RIRV = helperheightOfBinaryTree1(root.right, height);
            return Math.max(LIRV, RIRV);
        }

        public static int heightOfBinaryTree1(BinaryTree.Node root){
            helperheightOfBinaryTree1(root, 0);
        }


        //Approach-2 Post-Order Traversal
        public static int heightOfBinaryTree2(BinaryTree.Node root){
            if(root == null){
                return 0;
            }
            int LNIRV = heightOfBinaryTree2(root.left);
            int RNIRV = heightOfBinaryTree2(root.right);
            return Math.max(LNIRV, RNIRV) + 1;
        }




      //QUESTION-2 Diameter of Binary Tree
      //Source-https://leetcode.com/problems/diameter-of-binary-tree/description/

        int diameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            height(root);
            return diameter-1;

        }

        private static int height(TreeNode root){
            if(root == null){
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            int dia = leftHeight + rightHeight + 1;
            diameter = Math.max(dia, diameter);

            return Math.max(leftHeight, rightHeight) + 1;
        }




      //QUESTION-3 Invert a Binary Tree
      //Source-https://leetcode.com/problems/invert-binary-tree/

        //Approach-1 Breadth First Search
        public TreeNode invertTree(TreeNode root) {
            if(root==null){
                return null;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int levelSize = q.size();
                for(int i=0; i<levelSize; i++){
                    TreeNode current = q.poll();
                    TreeNode temp = current.left;
                    current.left = current.right;
                    current.right = temp;
                    if(current.left!=null){
                        q.offer(current.left);
                    }
                    if(current.right!=null){
                        q.offer(current.right);
                    }
                }
            }
            return root;
        }

        //Approach-2 Depth First Search(Pre-Order Traversal)
        public TreeNode invertTree(TreeNode root){
            invert(root);
            return root;
        }

        public void invert(TreeNode root){
            if(root==null){
                return;
            }

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invert(root.left);
            invert(root.right);
        }




      //QUESTION-4 Maximum Depth of Binary Tree
      //Source-https://leetcode.com/problems/maximum-depth-of-binary-tree/

        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            int leftHeight = maxDepth(root.left)+1;
            int rightHeight = maxDepth(root.right)+1;
            return Math.max(leftHeight, rightHeight);
        }




      //QUESTION-5 Flatten Binary Tree to Linked List
      //Source-https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

        //Approach-1 Depth First Search
        TreeNode prev = null;
        public void flatten(TreeNode root) {
            if(root == null){
                return;
            }

            flatten(root.right);
            flatten(root.left);

            root.right = prev;
            root.left = null;
            prev = root;
        }




      //QUESTION-6 Lowest Common Ancestor
      //Source-https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==p || root==q || root ==null){
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if(left != null && right !=null){
                return root;
            }

            return (left==null)?right:left;
        }




      //QUESTION-7 Construct Binary Tree from Preorder and Inorder Traversal
      //Source-https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

        int index = -1;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder.length==0){
                return null;
            }

            int p = preorder[0];
            int index = 0;

            for(int i=0; i<inorder.length; i++){
                if(p==inorder[i]){
                    index = i;
                }
            }

            TreeNode node = new TreeNode(p);

            node.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
            node.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index+1, inorder.length));

            return node;
        }




      //QUESTION-8 Path Sum
      //Source-https://leetcode.com/problems/path-sum/

       //Approach-1 Pre-Order Traversal
        public boolean hasPathSum1(TreeNode root, int targetSum) {
            if(root == null){
                return false;
            }

            if(root.left == null && root.right == null) {
                return (targetSum==root.val)?true:false;
            }

            boolean left = hasPathSum1(root.left, targetSum-root.val);
            boolean right = hasPathSum1(root.right, targetSum-root.val);

            return left || right;

        }
        //T3: TTL(Traverse Till Leaf)- Here we traversed till Leaf only. Beacuse of Empty Tree [] test case.




      //QUESTION-9 Sum Root to Leaf Numbers
      //Source-https://leetcode.com/problems/sum-root-to-leaf-numbers/

        public int sumNumbers(TreeNode root){
            return helper(root, 0);
        }

        public int helperForsumNumbers(TreeNode root, int sum) {
            if(root == null){
                return 0;
            }

            sum = sum * 10 + root.val;


            if(root.left == null && root.right ==null){
                return sum;
            }

            int left = helperForsumNumbers(root.left, sum);
            int right = helperForsumNumbers(root.right, sum);

            return left + right;
        }




      //QUESTION-10 Path Match From Root to Leaf
      //Source-https://www.geeksforgeeks.org/check-root-leaf-path-given-sequence/

        public boolean pathMatch(TreeNode root, int[] arr){
            return helperForPathMatch(root, arr, 0);
        }

        private boolean helperForPathMatch(TreeNode root, arr, int index){
            if(root == null || i>=arr.length){ //TP-Nodes are More to Match but the Array is Finished.
                return false;
            }

            if(root.val != arr[i]){
                return false;
            }

            if(root.left == null && root.right == null && i == arr.length-1){ //TP-On Leaf Node but Array Size is Graeter to Match.
                return true;
            }

            boolean left = helperForPathMatch(root.left, arr, index+1);
            boolean right = helperForPathMatch(root.right, arr, index+1);

            return left || right;

        }


      //QUESTION-11 Path Exists in Binary Tree at Any Nodes(R)


      //QUESTION-12 Same Tree
      //Source-https://leetcode.com/problems/same-tree/description/

        public boolean isSameTree(TreeNode p, TreeNode q) {

            //Base Condition: Till this if matches it means, all the values matches for a  Path.
            if(p == null && q == null){
                return true;
            }

            //Case-II: When there is node in one tree and null on other.
            if(p == null || q == null){
                return false;
            }

            //Case-I: When both values of nodes don't mathcehs.
            if(p.val != q.val){
                return false;
            }

            boolean LIRV = isSameTree(p.left, q.left);
            boolean RIRV = isSameTree(p.right, q.right);

            return LIRV && RIRV;
        }
        //T4: NULL CHECKER- If we want to check Null-Node Similarity use this. First use && and then \\.




      //QUESTION-13 Balanced Binary Tree
      //Source-https://leetcode.com/problems/balanced-binary-tree/description/

        boolean flag = false;
        public boolean isBalanced(TreeNode root) {
            maxDepth(root);
            return !flag;
        }

        private int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);

            if(Math.abs(leftHeight - rightHeight)>1){
                flag = true;
            }

            return Math.max(leftHeight, rightHeight) +1;
        }




      //QUESTION-14 Minimum Depth of Binary Tree
      //Source-https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

        public int minDepth(TreeNode root) {
            if(root == null){
                return 0;
            }

            int left = minDepth(root.left);
            int right = minDepth(root.right);

            return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
        }




      //QUESTION-15 Binary Tree Postorder Traversal
      //Source-https://leetcode.com/problems/binary-tree-postorder-traversal/description/
        public static void postorderTraversal(TreeNode temp, List<Integer> list){
            if(temp == null){
                return;
            }

            postorderTraversal(temp.left, list);
            postorderTraversal(temp.right, list);
            list.add(temp.val);

        }

        public static List<Integer> postorderTraversal(TreeNode temp){
            List<Integer> list = new ArrayList<>();
            postorderTraversal(temp, list);
            return list;
        }




      //QUESTION-16 Binary Tree Preorder Traversal
      //Source-https://leetcode.com/problems/binary-tree-preorder-traversal/description/

        public static void preorderTraversal(TreeNode temp, List<Integer> list){
            if(temp == null){
                return;
            }
            list.add(temp.val);
            preorderTraversal(temp.left, list);
            preorderTraversal(temp.right, list);

        }

        public static List<Integer> preorderTraversal(TreeNode temp){
            List<Integer> list = new ArrayList<>();
            preorderTraversal(temp, list);
            return list;
        }




      //QUESTION-17 Binary Tree Inorder Traversal
      //Source-https://leetcode.com/problems/binary-tree-inorder-traversal/description/

        public static void inorderTraversal(TreeNode temp, List<Integer> list){
            if(temp == null){
                return;
            }
            inorderTraversal(temp.left, list);
            list.add(temp.val);
            inorderTraversal(temp.right, list);

        }

        public static List<Integer> inorderTraversal(TreeNode temp){
            List<Integer> list = new ArrayList<>();
            inorderTraversal(temp, list);
            return list;
        }




      //QUESTION-18 Binary Tree Paths
      //Source-https://leetcode.com/problems/binary-tree-paths/

        List<String> ans = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            helper(root, "");
            return ans;
        }

        private void helper(TreeNode root, String s){
            if(root == null){
                return;
            }

            if(root.left == null && root.right == null){
                ans.add(s + root.val);
                return;
            }

            s = s + root.val + "->";
            helper(root.left, s);
            helper(root.right, s);
        }




      //QUESTION-19 Sum of Left Leaves
      //Source-https://leetcode.com/problems/sum-of-left-leaves/

         public int sumOfLeftLeaves(TreeNode root) {
              return helper(root, false);

         }

         private int helper(TreeNode root, boolean leftLeaf){
            if(root == null){
                return 0;
            }

            if(root.left ==  null && root.right == null ){
                return (leftLeaf)?root.val:0;
            }

            int left = helper(root.left, true);
            int right = helper(root.right, false);

            return left + right;
        }




      //QUESTION-20 Convert Sorted Array to Binary Search Tree
      //Source-https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

        public TreeNode helpersortedArrayToBST(int[] nums, int s, int e){
            if(s > e){
                return null;
            }

            int mid = s + (e - s)/2;
            TreeNode node = new TreeNode(nums[mid]);

            node.left = helpersortedArrayToBST(nums, s, mid-1);
            node.right = helpersortedArrayToBST(nums, mid + 1, e);

            return node;
        }

        public TreeNode sortedArrayToBST(int[] nums) {
            return helpersortedArrayToBST(nums, 0, nums.length-1);
        }




      //QUESTION-21 Validate Binary Search Tree
      //Source-https://leetcode.com/problems/validate-binary-search-tree/

        private boolean helper(TreeNode root, long min, long max){
            if(root == null){
                return true;
            }

            if(max <= root.val || min >= root.val){
                return false;
            }

            boolean left = helper(root.left, min, root.val);
            boolean right = helper(root.right, root.val, max);

            return left && right;
        }
        public boolean isValidBST(TreeNode root) {
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);

        }




      //QUESTION-22 Kth Smallest Element in a BST
      //QUESTION-23 Find Mode in Binary Search Tree
      //QUESTION-24 Minimum Absolute Difference in BST













}
