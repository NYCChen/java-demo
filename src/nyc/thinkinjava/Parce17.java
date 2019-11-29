package nyc.thinkinjava;

public class Parce17 {

    public Wrapping wrap(int x){
        return new Wrapping(x){
            public int value(){
                System.out.println(super.value() * 47);
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args){
        Parce17 p = new Parce17();
        Wrapping w = p.wrap(10);
    }

}
