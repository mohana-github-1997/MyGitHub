package NityaSoft;

class C{

     String c="C";
     String a="A";
}
class B{
    public C b(){
        return new C();
    }
}

public class Assignment {

    public static void main(String[] args){
      a().b().c=c().b().a;

    }
    private static B c() {
        return new B();
    }
    private static B a(){
        return new B();
    }
}
