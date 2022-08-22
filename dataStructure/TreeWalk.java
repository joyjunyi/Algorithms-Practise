package dataStructure;

public class TreeWalk {
    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        EmployNode root = new EmployNode(1,"Derek");
        EmployNode employ02 = new EmployNode(2,"Joy");
        EmployNode employ03 = new EmployNode(3,"Ma");
        EmployNode employ04 = new EmployNode(4,"Zhu");

        //说明，我们先手动创建二叉树，后面可以用递归的方式创建二叉树
        root.setLeft(employ02);
        //上面不能写root.left = employ02是因为left属性为私有，无法在外部更改
        root.setRight(employ03);
        employ03.setRight(employ04);

        //把root给binary tree
        binaryTree.setRoot(root);

        //测试
//        System.out.println("前序遍历");
//        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.inOrder();

//        System.out.println("后序遍历");
//        binaryTree.postOrder();
    }
}
//定义Binary Tree 二叉树
class BinaryTree{
    private EmployNode root;
    //给一个set方法

    public void setRoot(EmployNode root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void inOrder(){
        if(this.root != null){
            this.root.inOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
}
//先创建 EmployNode 节点
class EmployNode{
    private int id;
    private String name;
    private EmployNode left;    //默认null
    private EmployNode right;   //默认null
    //构造器

    public EmployNode(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //因为属性都是私有的，因此外部代码无法直接访问该变量
    //外部代码必须调用getter   getNumber()和setter， setNumber()以读取或更新变量
    //因此，Setter是一种更新变量值的方法。Getter是一种读取变量值的方法。Getter和setter 在Java 中也称为访问器和更改器。
    //setter和getter方法可保护变量的值免受外界（调用方代码）的意外更改。
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployNode getLeft() {
        return left;
    }

    public void setLeft(EmployNode left) {
        this.left = left;
    }

    public EmployNode getRight() {
        return right;
    }

    public void setRight(EmployNode right) {
        this.right = right;
    }

    //为了输出节点方便，此处重写toString方法
    //toString不加left和right是为了避免递归查找左右子节点
    @Override
    public String toString() {
        return "EmployNode:" +
                "id=" + id +
                ", name='" + name + '\'';
    }
    //编写前序遍历的方法
    public void preOrder(){
        System.out.println(this);   //先输出父节点
        //递归向左子树前序遍历
        if(this.left != null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if(this.right != null){
            this.right.preOrder();
        }
    }
    public void inOrder(){
        /* 中序遍历
        ①	如果当前节点的左子节点不为空，则递归中序遍历
        ②	输出当前节点
        ③	如果当前节点的右子节点不为空，则递归中序遍历
         */
        if(this.left != null){
            this.left.inOrder();
        }

        System.out.println(this);

        if(this.right != null){
            this.right.inOrder();
        }
    }
    public void postOrder(){
        /*	后序
        ①	如果当前节点的左子节点不为空，则递归后序遍历
        ②	如果当前节点的右子节点不为空，则递归后序遍历
        ③	输出当前节点
         */
        if(this.left != null){
            this.left.postOrder();
        }

        if(this.right != null){
            this.right.postOrder();
        }

        System.out.println(this);
    }
}