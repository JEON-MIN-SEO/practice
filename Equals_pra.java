class Equals_pra{
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        if(v1.equals(v2))
        System.out.println("same");
        else
        System.out.println("diffrent");
    }
}

class Value {
    int value;

    Value(int value){
        this.value = value;
    }

    public boolean equals(Object obj){
        Value v = (Value)obj;
        return this.value==v.value;
    }

}