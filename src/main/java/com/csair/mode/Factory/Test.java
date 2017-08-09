package com.csair.mode.Factory;

/**
 * 一、引子
 话说十年前，有一个爆发户，他家有三辆汽车（Benz（奔驰）、Bmw（宝马）、Audi（奥迪）看来这人比较爱国，没有日本车），还雇了司机为他开车。不过，爆发户坐车时总是这样：上Benz车后跟司机说"开奔驰车！"，坐上Bmw后他说"开宝马车！"，坐上Audi后他说"开奥迪车！"。你一定说：这人有病！直接说开车不就行了？！ 而当把这个爆发户的行为放到我们程序语言中来，我们发现C语言一直是通过这种方式来坐车的！幸运的是，这种有病的现象在OO语言中可以避免了。下面以Java语言为基础来引入我们本文的主题：工厂模式！！

 二、简介
 工厂模式主要是为创建对象提供了接口。工厂模式按照《Java与模式》中的提法分为三类：
 1. 简单工厂模式(Simple Factory)
 2. 工厂方法模式(Factory Method)
 3. 抽象工厂模式(Abstract Factory)
 这三种模式从上到下逐步抽象，并且更具一般性。还有一种分类法，就是将简单工厂模式看为工厂方法模式的一种特例，两个归为一类。下面是使用工厂模式的两种情况：
 1.在编码时不能预见需要创建哪种类的实例。
 2.系统不应依赖于产品类实例如何被创建、组合和表达的细节


 三、简单工厂模式
 顾名思义，这个模式本身很简单，而且使用在业务较简单的情况下。
 它由三种角色组成（关系见下面的类图）：
 1、工厂类角色：这是本模式的核心，含有一定的商业逻辑和判断逻辑。在java中它往往由一个具体类实现。
 2、抽象产品角色：它一般是具体产品继承的父类或者实现的接口。在java中由接口或者抽象类来实现。
 3、具体产品角色：工厂类所创建的对象就是此角色的实例。在java中由一个具体类实现。
 */
public class Test {
    public static void main(String[] args) {
        //今天做奔驰 简单工厂模式
        Car benchi = Driver.driverCar("benchi");
        //走起
        benchi.drive();

        //抽象工厂模式
        Driver2 driver = new BenChiDriver();
        Car benchi2 = driver.driver();
        benchi2.drive();


    }
}
