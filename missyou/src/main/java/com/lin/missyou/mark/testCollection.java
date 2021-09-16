package com.lin.missyou.mark;

// 做个基本的总结

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class testCollection {

    // List 常用方法
    // 向list集合添加元素
    // void add (Element element) {}
    // 指定位置添加 (指定index)
    // void add (int index, Element element) {}
    // 向集合添加另一个指定的集合元素
    // void addAll(Collection<? extends E> c) {}

    // 删除
    // void clear(); 清空集合所有原色

    // remove(int index) 根据指定索引删除元素
    //    boolean remove(Object o)：从集合中删除指定的元素
    //    boolean removeAll(Collection<?> c):从集合中删除一个指定的集合元素。
    //
    //    C:修改功能
    //    E set(int index, E element):把指定索引位置的元素修改为指定的值，返回修改前的值。
    //
    //    D:获取功能
    //    E get(int index)：获取指定位置的元素
    //    Iterator iterator():就是用来获取集合中每一个元素。
    //
    //    E:判断功能
    //    boolean isEmpty()：判断集合是否为空。
    //    boolean contains(Object o)：判断集合中是否存在指定的元素。
    //    boolean containsAll(Collection<?> c)：判断集合中是否存在指定的一个集合中的元素。
    //
    //    F:长度功能
    //    int size():获取集合中的元素个数
    //
    //    G:把集合转换成数组
    //    Object[] toArray():把集合变成数组。



    //  ArrayList基本操作

    //    List<String> list = new ArrayList<String>();
    //        System.out.println("ArrayList集合初始化容量："+list.size());
    //
    //    //添加功能：
    //        list.add("Hello");
    //        list.add("world");
    //        list.add(2,"!");
    //        System.out.println("ArrayList当前容量："+list.size());
    //
    //    //修改功能：
    //        list.set(0,"my");
    //        list.set(1,"name");
    //        System.out.println("ArrayList当前内容："+list.toString());
    //
    //    //获取功能：
    //    String element = list.get(0);
    //        System.out.println(element);
    //
    //    //迭代器遍历集合：(ArrayList实际的跌倒器是Itr对象)
    //    Iterator<String> iterator =  list.iterator();
    //        while(iterator.hasNext()){
    //        String next = iterator.next();
    //        System.out.println(next);
    //    }
    //
    //    //for循环迭代集合：
    //        for(String str:list){
    //        System.out.println(str);
    //    }
    //
    //    //判断功能：
    //    boolean isEmpty = list.isEmpty();
    //    boolean isContain = list.contains("my");
    //
    //    //长度功能：
    //    int size = list.size();
    //
    //    //把集合转换成数组：
    //    String[] strArray = list.toArray(new String[]{});
    //
    //    //删除功能：
    //        list.remove(0);
    //        list.remove("world");
    //        list.clear();
    //        System.out.println("ArrayList当前容量："+list.size());


    // LinkedList基本操作

    //    List<String> linkedList = new LinkedList<String>();
    //        System.out.println("LinkedList初始容量："+linkedList.size());
    //
    //    //添加功能：
    //        linkedList.add("my");
    //        linkedList.add("name");
    //        linkedList.add("is");
    //        linkedList.add("jiaboyan");
    //        System.out.println("LinkedList当前容量："+ linkedList.size());
    //
    //    //修改功能:
    //        linkedList.set(0,"hello");
    //        linkedList.set(1,"world");
    //        System.out.println("LinkedList当前内容："+ linkedList.toString());
    //
    //    //获取功能：
    //    String element = linkedList.get(0);
    //        System.out.println(element);
    //
    //    //遍历集合：(LinkedList实际的跌倒器是ListItr对象)
    //    Iterator<String> iterator =  linkedList.iterator();
    //        while(iterator.hasNext()){
    //        String next = iterator.next();
    //        System.out.println(next);
    //    }
    //    //for循环迭代集合：
    //        for(String str:linkedList){
    //        System.out.println(str);
    //    }
    //
    //    //判断功能：
    //    boolean isEmpty = linkedList.isEmpty();
    //    boolean isContains = linkedList.contains("jiaboyan");
    //
    //    //长度功能：
    //    int size = linkedList.size();
    //
    //    //删除功能：
    //        linkedList.remove(0);
    //        linkedList.remove("jiaboyan");
    //        linkedList.clear();
    //        System.out.println("LinkedList当前容量：" + linkedList.size());


    // 新用的到java9的一些特性
    public void test () {
        // java 9 doc  https://docs.oracle.com/javase/9/docs/api/java/util/List.html
        List<String> stringList = new ArrayList<>();
        // List.of();
        // https://docs.oracle.com/javase/9/docs/api/java/util/Map.html
        // Map.of()  Returns an immutable map containing zero mappings.

        // optional
        // java9为Optional添加了三个方法
        // or() ifPresentOrElse() stream()

    }


}
