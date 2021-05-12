    // Simple O(n) time and O(n) space complexity solution
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Init new array of same size
        int size = a.size();
        List<Integer> newA = Arrays.asList(new Integer[size]);
        
        // Using modular operations to calculate new position
        for(int i = 0; i < size; i++) {
            int newPos = (i + (size - d)) % size;
            newA.set(newPos, a.get(i));
        }
        return newA;   
    }
