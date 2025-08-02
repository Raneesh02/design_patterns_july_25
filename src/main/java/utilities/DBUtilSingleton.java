package utilities;

public class DBUtilSingleton {

    private static DBUtilSingleton dbUtilSingleton = new DBUtilSingleton();

    private DBUtilSingleton(){
        System.out.println("DB Util constructor called. connection opened" + this.hashCode());
    }

    public static DBUtilSingleton getInstance(){
        return dbUtilSingleton;
    }

    public void runQuery(String query){
        System.out.println(query+ " has run successfully");
    }

    public void printConfig(){
        System.out.println("db configuration");
    }
}