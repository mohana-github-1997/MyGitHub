package NityaSoft;


 class Student {
    Address b=new Address();
}
 class Address {
    String a="ABC";
    String c="PQR";
}
public class DemoMain {
    public static void main(String[] args){
        Student a=new Student();
        Student c=new Student();
        a.b.c=c.b.a;
    }
}
