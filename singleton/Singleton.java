public class Singleton{
    private static Singleton instance;

    private Singleton(){
        
    }

    public static Singleton getInstance(){
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }


}
class Main{
    public static void main(String[] args) {
        Singleton instance=Singleton.getInstance();
        Singleton instance2=Singleton.getInstance();
        Singleton instance3=Singleton.getInstance();
        Singleton instance4=Singleton.getInstance();
        System.out.println(instance.equals(instance4));
        System.out.println(instance2.equals(instance3));
    }
}