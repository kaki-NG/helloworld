package face;

/**
 * 1、定义一个Person的接口，其中有两个business method, getAge() 和getName()
 * @author Administrator
 *
 */
public interface Person { 
    public int getAge() throws Throwable; 
    public String getName() throws Throwable; 
}