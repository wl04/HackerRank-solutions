    // Solution
    public static int sockMerchant(int n, List<Integer> ar) {
        int numOfPairs = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        // Counting unique socks using HashMap where key is sock, value is amount 
        for (int i = 0; i < ar.size(); i++) {
            int aV = ar.get(i);
            if (!hm.containsKey(aV)) {
                hm.put(aV, 1);
            }
            else {
                int value = hm.get(aV);
                hm.put(aV, value + 1);
            }            
        }
        
        // Counting pairs
        for (Map.Entry entry : hm.entrySet()) {                
            int currentPairs = (Integer)entry.getValue() / 2; 
            if (currentPairs >= 1) {
                numOfPairs += currentPairs;
            }
        }
                
        return numOfPairs;
    }
