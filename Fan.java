
public class Fan {

        public static final int SLOW = 1;
        public static final int MEDIUM = 2;
        public static final int FAST = 3;

        private int speed=SLOW;
        private boolean isFanOn=false;
        private double radius=5;
        String color="blue";

        public Fan(){
            speed = 0;
            isFanOn = false;
            radius = 0.0;
            color = "";
        }


        public String toString(){
            String onOrOff;
            if(isFanOn())
                onOrOff="on";
            else
                onOrOff="off";

            if(isFanOn){
                return "A "+this.getRadius()+" inch "+this.getColor()+" fan at a speed of "+this.getSpeed();
            }else{
                return "A "+this.radius+" inch "+this.getColor()+" fan; fan is "+onOrOff;
            }
        }
        public int getSpeed() {
            return speed;
        }
        public void setSpeed(int speed) {
            this.speed = speed;
        }
        public boolean isFanOn() {

            return isFanOn;
        }
        public void setFanOn(boolean isFanOn) {
            this.isFanOn = isFanOn;
        }
        public double getRadius() {
            return radius;
        }
        public void setRadius(double radius) {
            this.radius = radius;
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }

}
