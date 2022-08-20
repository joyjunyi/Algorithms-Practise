package dataStructure;

public class Tree {
    public static void main(String[] args) {

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
                ", name='" + name + '\'' +
                "\n";
    }
    //编写前序遍历的方法
    
}