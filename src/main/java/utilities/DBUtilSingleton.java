package utilities;

public class DBUtilSingleton {

    //Early initialization
//    private static DBUtilSingleton dbUtilSingleton = new DBUtilSingleton();
//    public static DBUtilSingleton getInstance(){
//        return dbUtilSingleton;
//    }
//Early initialization

    //Lazy initialization
    private static DBUtilSingleton dbUtilSingleton;

    private DBUtilSingleton(){
        System.out.println("DB Util constructor called. connection opened" + this.hashCode());
    }

    public static DBUtilSingleton getInstance(){
        if(dbUtilSingleton==null) { //Thread 1 //Thread2
            dbUtilSingleton = new DBUtilSingleton(); //Thread 1
        }
        return dbUtilSingleton;
    }
    //lazy initialized

    public void runQuery(String query){
        System.out.println(query+ " has run successfully");
    }

    public static void printConfig(){
        System.out.println("db configuration");
    }
}