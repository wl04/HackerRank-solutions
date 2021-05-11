    // Solution
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Getting sum of elements in each array
        int sum1 = 0, sum2 = 0, sum3 = 0;
        sum1 = sumOfElements(h1);
        sum2 = sumOfElements(h2);
        sum3 = sumOfElements(h3);
        
        // Comparing sums and decreasing stacks
        boolean flag = true;
        while (flag) {
            if (sum1 == sum2 && sum1 == sum3) {
                flag = false;
                return sum1;
            } 
            else if (sum1 >= sum2 && sum1 >= sum3) {
                int value = h1.remove(0);
                sum1 -= value;
                continue;
            }
            else if (sum2 >= sum1 && sum2 >= sum3) {
                int value = h2.remove(0);
                sum2 -= value;
                continue;
            }
            else if (sum3 >= sum1 && sum3 >= sum2) {
                int value = h3.remove(0);
                sum3 -= value;
                continue;
            }
            else return 0;    
        }
        return 0;
    }
    
    // Sum array
    public static int sumOfElements(List<Integer> arr) {
        int sum = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }
