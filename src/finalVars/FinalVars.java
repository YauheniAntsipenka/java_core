package finalVars;

public class FinalVars {
    public static final String CONSTANT = "CONSTANT";

    public void getConstant(){
        System.out.println(CONSTANT);
    }

    FinalVars(){
        System.out.println("text");
//        Child child = new Child();
//        child.printText("sdf");
    }

    public void getChildsText(){
        FinalVars finalVars = new Child();
        finalVars.printText("qqq");
    }

    public void printText(String text){
        System.out.println(text);
    }
}

class Child extends FinalVars{
    Child(){
        System.out.println("child text");
    }
//    @Override
//    public void printText(String text){
//        super.printText(text);
//        System.out.println(text + "CHILD");
//    }
}
