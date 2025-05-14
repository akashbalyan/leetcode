class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        // Count paths that start from the current root
        int countFromRoot = countPathsFromNode(root, targetSum);

        // Try the same for left and right subtrees
        int countLeft = pathSum(root.left, targetSum);
        int countRight = pathSum(root.right, targetSum);

        return countFromRoot + countLeft + countRight;
    }

    private int countPathsFromNode(TreeNode node, long targetSum) {
        if (node == null) return 0;

        int count = 0;

        if (node.val == targetSum) count++;

        // Continue downward path
        count += countPathsFromNode(node.left, targetSum - node.val);
        count += countPathsFromNode(node.right, targetSum - node.val);

        return count;
    }
}
