// Solution
class MyCalculator implements AdvancedArithmetic {
    public int divisor_sum(int num) {
        if (num == 1) {
            return 1;
        }
        else {            
            int sum = 1 + num; // Any number can be devided by 1 and by the number itself
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;                
                }
            }
            return sum;                       
        }
    }
}
