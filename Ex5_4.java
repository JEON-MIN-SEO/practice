class Ex5_4 {
public static void main(String args[]) {
    //大きな金額から優先的に返さなきゃならない
    int[] coinUount = {500, 100, 50, 10};

    int money = 2680;
    System.out.println("money="+ money);

    for(int i=0; i<coinUount.length; i++){
            int coin;
            coin = money/coinUount[i];
            money %= coinUount[i];
            System.out.println(coinUount[i]+"won :"+coin);

            //答え
            //System.out.println(coinUnit[i]+"won: "+money/coinUnit[i]); 
            //money = money%coinUnit[i];
        }
    }
}

// money=2680 
// 500won: 5 
// 100won: 1 
// 50won:  1 
// 10won:  3