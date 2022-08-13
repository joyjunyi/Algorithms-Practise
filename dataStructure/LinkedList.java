package dataStructure;
/*
完成对链表增删改查的功能
 */
public class LinkedList {
    public static void main(String[] args) {

    }
}
//定义SingleLinkedList，来管理Student
class SingleLinkedList{
    //先初始化一个 Head，头节点不要动，不存放具体数据
    private Student head = new Student(0,"","");

    //添加节点到单向链表
    
}
//定义Student,每个Student对象就是一个节点
class Student{
    public int no;
    public String name;
    public String nickname;
    public Student next;    //指向下一个节点
    //构造器
    public Student(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了方便显示，重写toString
    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
