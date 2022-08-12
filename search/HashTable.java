package search;

import java.util.Scanner;

/*
国内谷歌面试题：当新员工报到时，在系统内快速找到他的ID，姓名，年龄等信息
不能用数据库，速度越快越好 （用哈希表）
 */
public class HashTable {
    public static void main(String[] args) {
        //创建一个哈希表
        HashTab hashTab = new HashTab(7);

        //写一个简单菜单
        String key = "";
        Scanner myScanner = new Scanner(System.in);
        while(true){
            System.out.println("add：添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("exit：退出系统");
            
            key = myScanner.next();
            switch (key){
                case"add":
                    System.out.println("输入id");
                    int id = myScanner.nextInt();
                    System.out.println("输入姓名");
                    String name = myScanner.next();
                    //创建雇员
                    Employ employ = new Employ(id,name);
                    hashTab.add(employ);
                    break;
                case"list":
                    hashTab.list();
                    break;
                case"exit":
                    myScanner.close();
                default:
                    break;
            }
        }
    }
}
//最后写，哈希表
//创建哈希表，管理多条链表
class HashTab{
    private EmployLinkedList[] employLinkedListArray;
    private int size;   //表示共有多少条链表

    //构造器
    public HashTab(int size){
        //初始化链表employLinkedListArray
        employLinkedListArray = new EmployLinkedList[size];
    }
    //添加雇员
    public void add(Employ employ){
        //根据员工的id，得到该员工应该添加到哪条链表
        int employLinkedListNO = hashFunction(employ.id);
        //将 employ 添加到对应的链表中
        employLinkedListArray[employLinkedListNO].add(employ);
    }
    //遍历所有的链表,遍历哈希表
    public void list(){
        for(int i = 0 ; i < size ; i++){
            employLinkedListArray[i].list();
        }
    }
    //编写散列函数，使用一个简单的取模法
    public int hashFunction(int id){
        return id % size;
    }

}

//表示一个雇员
class Employ{
    public int id;
    public String name;
    //指向下一个节点的地址
    public Employ next; //next默认为空null

    public Employ(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
//创建EmployLinkedList,表示链表
class EmployLinkedList{
    //头指针，指向第一个雇员，因此我们这个链表的head是有效的
    //直接指向第一个雇员
    private Employ head;    //默认为空null
    //添加雇员到链表
    /*
    说明
    假定，当添加雇员时，id是自增的，即id的分配总是从小到大
    因此，我们新添加的雇员直接添加到本链表最后一个即可
     */
    public void add(Employ employ){
        //如果是添加第一个雇员
        if (head == null){
            head = employ;
            return;
        }
        //如果不是第一个雇员，我们就需要辅助指针，帮助定位到最后
        Employ currentEmploy = head;
        while(true){
            if(currentEmploy.next == null){ //说明已经到最后
                break;
            }
            currentEmploy = currentEmploy.next;     //后移
        }
        //退出时，直接将employ加入链表
        currentEmploy.next = employ;
    }
    //遍历链表的雇员信息
    public void list(){
        if(head == null){   //说明链表为空
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("当前链表的信息为");
        Employ currentEmploy = head;    //创建辅助指针
        while(true){
            System.out.printf("=> id=%d name=%s\t", currentEmploy.id,currentEmploy.name);
            if(currentEmploy.next == null){     //说明currentEmploy已经是最后节点
                break;
            }
            currentEmploy = currentEmploy.next;  //后移，然后遍历
        }
        System.out.println("");
    }

}


