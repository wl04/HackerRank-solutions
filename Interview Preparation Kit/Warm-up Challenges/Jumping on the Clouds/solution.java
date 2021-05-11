    // Solution
    public static int jumpingOnClouds(List<Integer> c) {
        int numberOfSteps = 0;
        int numberOfClouds = c.size();
        int i = 0;
        
        while (i < numberOfClouds) {
            // Determining max and min step to prevent out of bounds error
            int maxStep = numberOfClouds - 2 - i - 1;
            int minStep = numberOfClouds - 1 - i - 1;
            
            // If max step possible 
            if (maxStep >= 0 && c.get(i + 2) != 1) {
                numberOfSteps++;
                i += 2;
                continue;
            } //If min step possible
            else if (minStep >= 0 && c.get(i + 1) != 1) {
                numberOfSteps++;
                i += 1;
                continue;
            }
            else i+= 1;
        }
        return numberOfSteps;
    }
