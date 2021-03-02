package innerClasses;

public class Car {
    public void go(){
        System.out.println("car is going");
    }
    public Car() {
    }

    public Car(int enginePower, double engineVolume, String doorColor, double doorWear) {
        Engine engine = new Engine();
        engine.setPower(enginePower);
        engine.setVolume(engineVolume);

        Door door = new Door();
        door.setColor(doorColor);
        door.setWear(doorWear);
    }

    class Engine extends Iron{
        private Car car;
        private double volume; //объем
        private int power; //мощность

        public void startEngine(){
            System.out.println("wrum-wrum");
            super.getTemperature(); // множественное наследование. кек
            car.go();
        }

        public Engine() {
            car = Car.this; //получаем ссылку на объект Car из текущего контекста
        }

        public double getVolume() {
            return volume;
        }

        public void setVolume(double volume) {
            this.volume = volume;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        @Override
        public String toString() {
            return "Engine{" +
                "volume=" + volume +
                ", power=" + power +
                '}';
        }
    }

    class Door{
        private String color;
        private double wear; //износ

        public void open(){
            System.out.println("opened");
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public double getWear() {
            return wear;
        }

        public void setWear(double wear) {
            this.wear = wear;
        }

        @Override
        public String toString() {
            return "Door{" +
                "color='" + color + '\'' +
                ", wear=" + wear +
                '}';
        }
    }

    //@todo чекнуть, почему нельзя вывести инфу о вложенных
    @Override
    public String toString() {
        return "Car{ }";
    }
}


class Iron{
    public void getTemperature(){
        System.out.println("cold");
    }
}