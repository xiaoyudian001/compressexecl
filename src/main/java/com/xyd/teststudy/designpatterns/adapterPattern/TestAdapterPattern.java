package com.xyd.teststudy.designpatterns.adapterPattern;

/**
 * 适配器模式（Adapter Pattern）是一种结构型设计模式，用于将一个类的接口转换成客户端所期望的另一个接口。
 * 它可以让原本接口不兼容的类可以一起工作，提供了类之间的协调和兼容性。
 * <p>
 *     适配器模式通常包含以下角色：
 *
 * 目标接口（Target Interface）：定义了客户端期望使用的接口。客户端通过该接口与适配器进行交互。
 * 适配器（Adapter）：实现了目标接口，同时持有一个需要适配的对象实例。适配器将客户端的请求转换为适配对象的方法调用，并将结果返回给客户端。
 * 适配对象（Adaptee）：已经存在的类或对象，其接口与目标接口不匹配。适配器将客户端的请求转发给适配对象，实现了客户端与适配对象的适配。
 * </p>
 */
public class TestAdapterPattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer=new AudioPlayer();
        audioPlayer.play("mp3","song.mp3");
        audioPlayer.play("mp4","song.mp4");
        audioPlayer.play("wav","song.wav");
    }



}
