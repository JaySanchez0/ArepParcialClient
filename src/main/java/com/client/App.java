package com.client;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       HttpPostRequest post = new HttpPostRequest("https://dry-castle-98365.herokuapp.com/sort");
        ArrayList<Double> list = new ArrayList<Double>();
        list.add(3.0);
        list.add(4.0);
        list.add(-1.0);
        list.add(-2.0);
        list.add(9.0);
        list.add(7.0);
        System.out.println("Lista");
        for(double d: list) System.out.print(d+" ");
        System.out.println();
        System.out.println("Sort List");
        System.out.println(post.send(list));
        post = new HttpPostRequest("https://dry-castle-98365.herokuapp.com/dataOperation");
        System.out.println("Object Operation");
        String[] o  =post.send(list).replace("{","").replace("}","").replace("\"","").split(",");
        System.out.println(o[0]);
        System.out.println(o[1]);
    }
}
