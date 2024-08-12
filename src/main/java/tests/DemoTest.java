package tests;

import base.TestBase;
import org.testng.annotations.Test;

public class DemoTest extends TestBase {
    @Test
    public void myTest(){
        System.out.println("10/0");
    }

    @Test
    public void myTest2(){
        System.out.println("10/0");
    }
}
