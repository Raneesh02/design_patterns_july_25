package tests;

import org.testng.annotations.Test;
import utilities.DBUtil;
import utilities.DBUtilSingleton;

public class DBUtilSingletonTests {

    // Common Before Class
//    @BeforeClass
//    public void initDBUtil(){
//        DBUtil dbUtil= new DBUtil();
//    }

    @Test
    public void test1(){
        DBUtilSingleton dbUtilSingleton = DBUtilSingleton.getInstance();
        dbUtilSingleton.runQuery("select * test1");
    }

    @Test
    public void test2(){
        DBUtilSingleton dbUtilSingleton = DBUtilSingleton.getInstance();
        dbUtilSingleton.runQuery("select * test2");
    }

    @Test
    public void test3(){
        DBUtilSingleton dbUtilSingleton = DBUtilSingleton.getInstance();
        dbUtilSingleton.runQuery("select * test3");
    }

}