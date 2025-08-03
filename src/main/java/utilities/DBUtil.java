package utilities;

public class DBUtil {

    public DBUtil(){
        System.out.println("DB Util constructor called. connection opened" + this.hashCode());
    }

    public void runQuery(String query){
        System.out.println(query+ " has run successfully");
    }

    public void printConfig(){
        System.out.println("db configuration");
    }
}