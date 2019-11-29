package nyc.thinkinjava;




public class Parce18 {
    public Destination dest (final String dest){
        return new Destination(){
            private String label = dest;
            public String readLabel() { return label; }
        };
    }

    public static void main(String[] args){
        Parce18 p = new Parce18();
        Destination d = p.dest("Tanzania");
    }
}
