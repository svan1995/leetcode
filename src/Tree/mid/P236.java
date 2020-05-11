package Tree.mid;
// 二叉树的最近公共祖先

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//        例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class P236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        System.out.println(treeNode.val);
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}



