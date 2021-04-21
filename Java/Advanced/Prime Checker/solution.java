import static java.lang.System.in; // To deal with compile time error importing as static

class Prime {
    public static void checkPrime(int ... numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            boolean flag = false;
           
            // No number is divisible by more than half of itself. So we need to loop through just num / 2            
            for (int div = 2; div <= num / 2; div++) {
                if (num % div == 0) {
                    flag = true;
                    break;
                }
            }
            
            if (num == 1) {
                flag = true;
            }
            
            if (!flag) {
                System.out.print(num + " ");
            }   
        }
        System.out.println();
    }
}
