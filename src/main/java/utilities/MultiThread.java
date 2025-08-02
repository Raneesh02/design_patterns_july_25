package utilities;

public class MultiThread extends Thread{
    @Override
    public void run() {
        DBUtilSingleton instance = DBUtilSingleton.getInstance();
        instance.runQuery(this.getName()+" query");
    }
}