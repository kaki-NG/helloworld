package client;

import stub.Person_Stub;
import face.Person;

/**
 * 5、最后一个，Client的实现
 * Client的本质是，它要知道Person接口的定义，并实例一个Person_Stub，通过Stub来调用business method，至于Stub怎么去和Server沟通，Client就不用管了。
 * 注意它的写法：Person person = new Person_Stub(); 而不是 Person_Stub person = new Person_Stub();  为什么？因为要面向接口编程嘛，呵呵！
 * @author Administrator
 *
 */
public class PersonClient { 
    public static void main(String [] args) { 
        try { 
            Person person = new Person_Stub(); 
            int age = person.getAge(); 
            String name = person.getName(); 
            System.out.println(name + " is " + age + " years old"); 
        } catch(Throwable t) { 
            t.printStackTrace(); 
        } 
    } 
}