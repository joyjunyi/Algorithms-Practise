package dataStructure;
/*
完成对链表增删改查的功能
 */
public class LinkedList {
    public static void main(String[] args) {
        //创建节点
        Student student01 = new Student(01,"张三","小张");
        Student student02 = new Student(02,"玛丽","小马");
        Student student03 = new Student(03,"戴西","小戴");
        Student student04 = new Student(04,"王五","小王");

        //创建一个链表，然后按id顺序加入节点
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(student01);
        singleLinkedList.addByOrder(student04);
        singleLinkedList.addByOrder(student02);
        singleLinkedList.addByOrder(student03);

        //修改节点
        Student newStudent03 = new Student(03,"戴森","小森");
        singleLinkedList.update(newStudent03);

        //删除节点
        singleLinkedList.delete(student03);
        singleLinkedList.delete(student04);

        //显示整个链表
        singleLinkedList.traverse();
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
    //按照序号将新节点插入到链表
    //如果序号重复，请提示
    public void addByOrder(Student student){
        Student temp = head;    //我们要找的位置的新节点前一个，所以这里的temp不是等于head.next
        boolean flag = false;   //添加的编号是否存在
        while(true){
            if(temp.next == null){  //说明已经到链表最后一位
                break;      //这时不管找到没找到都要break
            }
            if(temp.next.id > student.id){  //位置找到，插入到temp后面
                break;
            }else if(temp.next.id == student.id){ //编号已存在
                flag = true;
                break;
            }
            temp = temp.next;   //后移（遍历）
        }
        //判断flag的值
        if(flag){
            System.out.println("此学生编号"+student.id+"已存在");
        }else{
            //插入到链表中，temp的后面
            student.next = temp.next;
            temp.next = student;
        }
    }
    //修改节点
    public void update(Student updatedStudent){
        Student temp = head.next;
        //先判断是否为空
        if(temp == null){
            System.out.println("链表为空");
            return;
        }
        //新建标识，记录节点是否被找到
        boolean flag = false;
        while(true){
            if(temp == null) {
                break;      //表示遍历完链表了，
            }
            if(temp.id == updatedStudent.id){   //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到
        if(flag){
            temp.name = updatedStudent.name;
            temp.nickname = updatedStudent.nickname;
        }else{  //没有找到
            System.out.println("没有找到编号为"+updatedStudent.id+"的节点，无法修改");
        }
    }
    //删除节点
    //遍历链表 => 找到要删节点的前一个节点 => 让前一个节点的next指向下下个节点
    public void delete(Student deleteStudent){
        //因为要找待删节点的前一个节点，因此temp == head，不等于head.next
        Student temp = head;
        //检查链表是否为空，为空就不遍历了
        if(temp.next == null){
            System.out.println("链表为空，不能删除");
            return;
        }
        //新建标识，记录节点是否被找到
        boolean flag = false;
        //如果链表不为空，则遍历
        while(true){    //造个死循环
            //判断是否到链表最后
            if(temp.next == null){
                break;
            }
            if(temp.next.id == deleteStudent.id){
                flag = true;
                break;
            }
            //temp后移
            temp = temp.next;
        }
        if(flag) {
            temp.next = temp.next.next;
        }else{
            System.out.println("未找到节点，无法删除");
        }
    }

    // 打印链表
    // 通过遍历打印所有节点，也需要借助辅助变量
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
            //判断是否到链表最后
            if(temp == null){
                break;
            }
            //没有到最后的话，输出链表
            //因为Student类已经重写toString方法了，因此直接打印即可
            System.out.println(temp);
            //temp后移
            temp = temp.next;
        }
    }
}
//定义Student,每个Student对象就是一个节点
class Student{
    public int id;
    public String name;
    public String nickname;
    public Student next;    //指向下一个节点
    //构造器
    public Student(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }
    //为了方便显示，重写toString
    //自动生成的toString记得把next部分去了，否则会连续输出所有节点
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
