    // Solution
    public static long repeatedString(String s, long n) {
        // Special case
        if (s.equals("a")) return n;
        
        long numOfA = 0L;
        long len = s.length();
        long evenOcc = n / len; // even number of occurancies of s in result string
        long remCharNum = n % len; // number of remaining characters
        
        // Counting 'a' occurancies in initial string
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'a') numOfA++;    
        }

        numOfA *= evenOcc; // biggest part of 'a' occurancies
    
        // Counting 'a' occurancies in remaining string
        String remStr = s.substring(0, (int)remCharNum);
        for (int j = 0; j < remStr.length(); j++) {
            if (remStr.charAt(j) == 'a') numOfA++;
        } 
        return numOfA;
    }
