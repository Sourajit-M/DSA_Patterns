package greedy_algo;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int bill : bills){
            if(bill == 5){
                five++;
            }else if(bill == 10){
                if(five == 0)
                    return false;
                five--;
                ten++;
            }
            //bill is 20
            else{
                //if 10 and 5 both avail give them 
                if(ten>0 && five>0){
                    five--;
                    ten--;
                }
                //ten is not there, we need 3  5 notes
                else if(five >= 3)
                    five -= 3;
                else
                    return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
        System.out.println(lemonadeChange(bills));
    }
}
