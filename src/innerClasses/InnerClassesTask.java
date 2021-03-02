package innerClasses;

public class InnerClassesTask {
    public static void start(){
        Car car = new Car(250,3.0,"Green",0.5);
        System.out.println(car);


        Car car1 = new Car();
        Car.Door door = car1.new Door();
        door.setWear(0.2);
        door.setColor("yellow");
        Car.Engine engine = car1.new Engine();
        engine.startEngine();
        System.out.println(door);

        AnonOuter anonOuter = new AnonOuter();
        anonOuter.get();
    }
}
