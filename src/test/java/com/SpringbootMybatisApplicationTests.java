package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));
        int i=8,j=16;
        if( i-1 > j ) i--;
        else j--;
        System.out.println(i);
        System.out.println(j);
        System.out.println(1111111111);
    }

}
//class Person{
//        static int arr[] = new int[10];
//        public static void main(String a[]) {
//            int i=0;
//            System.out.println(i);
//        }
//}
