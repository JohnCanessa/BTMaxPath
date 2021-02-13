import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * Leetcode 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BTMaxPathSum {


    // **** holds the max path sum value ****
    static int maxPS;


    /**
     * Depth first search based.
     * Recursive method.
     */
    static int pathSum(TreeNode node) {

        // **** sanity check(s) ****
        if (node == null)
            return 0;

        // **** path sum of left subtree ****
        int leftSum = Math.max(0, pathSum(node.left));

        // **** path sum of right subtree ****
        int rightSum = Math.max(0, pathSum(node.right));

        // **** compute complete path sum ****
        int sum = leftSum + rightSum + node.val;

        // ???? ????
        System.out.println("<<< node.val: " + node.val + 
                        " leftSum: " + leftSum + " rightSum: " + rightSum +
                        " sum: " + sum);

        // **** update the max path sum (if needed) ****
        maxPS = Math.max(maxPS, sum);

        // **** return the sum of the longest path including the current node ****
        return Math.max(leftSum, rightSum) + node.val;
    }


    /**
     * Given the root of a binary tree, return the maximum path sum of any path.
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 40.7 MB, less than 86.25% of Java online submissions.
     */
    static int maxPathSum(TreeNode root) {

        // **** initialization ****
        maxPS = Integer.MIN_VALUE;

        // **** generate the max path sum and update maxPS ****
        pathSum(root);

        // **** return maxPS ****
        return maxPS;
    }


    /**
     * Test scaffolding
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** open a buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** create String[] with values for the BT ****
        String[] strArr = br.readLine().trim().split(",");

        // **** close the buffered reader ****
        br.close();
        
        // ???? ????
        System.out.println("main <<< strArr: " + Arrays.toString(strArr));

        // **** generate an Integer[] to build the BT ****
        Integer[] arr = new Integer[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("null"))
                arr[i] = null;
            else
                arr[i] = Integer.parseInt(strArr[i]);
        }

        // ???? ????
        System.out.println("main <<<    arr: " + Arrays.toString(arr));

        // **** create and populate the binary tree ****
        BST bt = new BST();
        bt.root = bt.populate(arr);
    
        // ???? ????
        System.out.println("main <<< bt levelOrder:");
        System.out.println(bt.levelOrder());

        // **** get the maximum path sum of any path****
        int maxPS = maxPathSum(bt.root);
        
        // ???? ????
        System.out.println("main <<< maxPS: " + maxPS);
    }
}