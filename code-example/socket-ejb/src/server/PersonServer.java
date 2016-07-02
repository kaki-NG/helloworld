package server;

import face.Person;

/**
 * 2、Person的实现PersonServer类
 * @author Administrator
 *
 */
public class PersonServer implements Person { 
    int age; 
    String name; 

    public PersonServer(String name, int age) { 
        this.age = age; 
        this.name = name; 
    } 

    public int getAge() { 
        return age; 
    } 

    public String getName() { 
        return name; 
    } 
} 