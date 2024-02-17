class Card {
	String kind;
	

	// Card() {
	// 	this("SPADE", 1);
	// }

	Card(String kind) {
		this.kind = kind;
	}
    public boolean equals(Object obj){
        if(!(obj instanceof Card))
        return false;

        Card c = (Card)obj;
        //return this.kind.equals(c.kind) && this.number == c.number;
        return this.kind == c.kind;
    }

}

class hashCode {
	public static void main(String[] args) {
		Card c1 = new Card("SPADE");
		Card c2 = new Card("SPADE");

        System.out.println(c1.equals(c2));
		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}
}