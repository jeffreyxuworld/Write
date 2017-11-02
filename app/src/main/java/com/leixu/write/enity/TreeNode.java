package com.leixu.write.enity;

import com.leixu.write.util.FindShortestBTPath;

/**
 * Created by Lei on 2017/10/28.
 *
 */

public class TreeNode {
    public int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

}
