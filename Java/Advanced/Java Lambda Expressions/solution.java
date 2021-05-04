// Solution
    public PerformOperation isOdd() {
        return (int x) -> x % 2 == 0 ? false : true; 
    }
    
    public PerformOperation isPrime() {
        return (int x) -> {
            for (int i = 2; i < x / 2; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        };
    }
    
    public PerformOperation isPalindrome() {
        return (int x) -> {
            int r, sum = 0;
            int temp = x;
            
            while (x > 0) {
                r = x % 10;
                sum = (sum * 10) + r;
                x = x / 10;
            }        
            return temp == sum ? true : false;
        };
    }
}
