    // Solution
    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> trackSt = new Stack<>();
        
        List<Integer> result = new ArrayList<>();
        int current = 0;
         
        // Iterating through operations list
        Iterator<String> it = operations.iterator();
        while (it.hasNext()) {
            String[] splited = it.next().split("\\s+");
            switch (splited[0]) {
                case "1":
                    current = Integer.parseInt(splited[1]); 
                    st.push(current);
                    
                    if (st.size() == 1) { 
                        trackSt.push(current); 
                        break; 
                    } 
                    // If current element is greater than the top element of track 
                    // stack, push the current element to track stack otherwise push 
                    // the element at top of track stack again into it. 
                    if (current > trackSt.peek()) 
                        trackSt.push(current); 
                    else
                        trackSt.push(trackSt.peek()); 
                    break;
                case "2":
                    st.pop();
                    trackSt.pop();
                    break;
                case "3":
                    current = trackSt.peek();
                    result.add(current);
                    break;
            }
        }
        return result;
    }
