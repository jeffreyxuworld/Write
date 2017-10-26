package com.leixu.write.util;

/**
 * Created by Lei on 2017/10/20.
 * 保证了在程序中只有一个实例存在并且能全局的访问到
 */

public class WriteInstance {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static WriteInstance instance = null;

    /* 私有构造方法，防止被实例化 */
    private WriteInstance() {
    }

    /*懒汉式变种，解决线程安全问题**/

    /**
     * 优点：解决了线程不安全的问题。
       缺点：效率有点低，每次调用实例都要判断同步锁
     */
    public synchronized static WriteInstance getInstance(){
        if(instance == null){
            instance = new WriteInstance();
        }
        return instance;
    }

    /*加上synchronized，但是每次调用实例时都会加载**/
    /**
     * Retrieve the global WriteInstance instance, creating it if it
     * doesn't already exist.
     */
//    public static WriteInstance getInstance() {
//        synchronized (WriteInstance.class) {
//            if (instance == null) {
//                instance = new WriteInstance();
//            }
//        }
//        return instance;
//    }


    /* 懒汉式，静态工程方法，创建实例 */

    /**
     * 优点：延迟加载（需要的时候才去加载）
       缺点： 线程不安全，在多线程中很容易出现不同步的情况，如在数据库对象进行的频繁读写操作时。
     */

//    public static WriteInstance getInstance(){
//        if(instance == null){
//            instance = new WriteInstance();
//        }
//        return instance;
//    }


    public void setInstance(WriteInstance instance){
        WriteInstance.instance = instance;
    }

}
