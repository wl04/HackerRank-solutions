        boolean needToCheck = true;
        
        while (needToCheck) {
            needToCheck = false;
                
            for (int i = 1; i < n; i++) {
                try {
                    BigDecimal currentN = new BigDecimal(s[i]);
                    BigDecimal previousN = new BigDecimal(s[i - 1]);  
                    int res = currentN.compareTo(previousN);
                
                    // Swapping elements
                    if (res == 1) { 
                        String temp = s[i];
                        s[i] = s[i - 1];
                        s[i - 1] = temp;
                        needToCheck = true;
                    }     
                }
                catch (Throwable t)
                {
                    System.out.println("I: "+ i);
                }                   
            }
        } 
