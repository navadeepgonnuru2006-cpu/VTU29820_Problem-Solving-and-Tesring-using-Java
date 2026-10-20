
import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private List<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void addChild(Tree child) {
        children.add(child);
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child : children) {
            child.accept(visitor);
        }
    }
}

class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private static final int MOD = 1000000007;
    private long product = 1;

    public int getResult() {
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthNonLeafSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        return Math.abs(evenDepthNonLeafSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthNonLeafSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class Solution {

    public static Tree solve() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] values = new int[n];
        Color[] colors = new Color[n];

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt() == 0 ? Color.RED : Color.GREEN;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Tree[] nodes = new Tree[n];
        boolean[] visited = new boolean[n];

        return buildTree(0, -1, 0, values, colors, adj, nodes);
    }

    private static Tree buildTree(
        int current, int parent, int depth,
        int[] values, Color[] colors,
        List<List<Integer>> adj, Tree[] nodes
    ) {
        List<Integer> children = new ArrayList<>();

        for (int next : adj.get(current)) {
            if (next != parent) {
                children.add(next);
            }
        }

        if (children.isEmpty()) {
            nodes[current] = new TreeLeaf(values[current], colors[current], depth);
            return nodes[current];
        }

        TreeNode node = new TreeNode(values[current], colors[current], depth);
        nodes[current] = node;

        for (int child : children) {
            node.addChild(buildTree(
                child, current, depth + 1,
                values, colors, adj, nodes
            ));
        }

        return node;
    }

    public static void main(String[] args) {
        Tree root = solve();

        SumInLeavesVisitor v1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor v2 = new ProductOfRedNodesVisitor();
        FancyVisitor v3 = new FancyVisitor();

        root.accept(v1);
        root.accept(v2);
        root.accept(v3);

        System.out.println(v1.getResult());
        System.out.println(v2.getResult());
        System.out.println(v3.getResult());
    }
}
