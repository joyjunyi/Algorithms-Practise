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
    //1.找到最后一个节点
    //2.将最后一个节点的next指向新节点
    public void add(Student student){
        //由于头节点不能动，因此我们需要一个辅助变量 temp
        Student temp = head;
        //遍历链表，找到最后
        while(true){    //造个死循环
            if(temp.next == null){  //找到最后一个了
                break;
            }
            temp = temp.next;   //没找到就将temp后移
        }
        //退出while循环时，temp已经是链表的最后
        //此时连上最后一个节点即可
        temp.next = student;    //形参列表里新加入的节点
    }
    // 验证一下，显示链表，
    // 通过遍历显示所有节点，也需要借助辅助变量
    public void traverse(){
        //检查链表是否为空，为空就不遍历了
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //如果不为空，则遍历
        //因为头结点不能动，索引需要一个辅助变量
        Student temp = head.next;
        while(true){    //造个死循环
            

        }
    }
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
