// Solution
    public static int countingValleys(int steps, String path) {
        int numOfValleys = 0;
        int h = 0;
        boolean stepOverSeaLevel = true;
   
        for (int i = 0; i < path.length(); i++) {
            
            // Change h according to path
            if (path.charAt(i) == 'U') {
                h++;
            }
            else if (path.charAt(i) == 'D') {
                h--;
            }
            
            // if we step over sea level to negative h then it's a valley
            if (h < 0 && stepOverSeaLevel == true) {
                numOfValleys++;
            } 
            
            // Changing step over flag
            if (h == 0) {
                stepOverSeaLevel = true;    
            } else if (h > 0 || h < 0) {
                stepOverSeaLevel = false;
            }  
        }
        return numOfValleys;
    }
