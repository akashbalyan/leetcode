class Solution {
    public int romanToInt(String s) {
        
        char arr [] = s.toCharArray();
        int i=0;
        int sum =0;
        while(i<arr.length){
            if(arr[i] == 'M'){
                sum = sum +1000;
            }else if(arr[i] == 'D'){
                sum = sum +500;
            }else if(arr[i] == 'C'){
                if(i+1 != arr.length && arr[i+1] == 'M'){
                    sum+=900;
                    i=i+2;
                    continue;
                }else if(i+1 != arr.length && arr[i+1] == 'D'){
                    sum+=400;
                    i=i+2;
                    continue;
                }else{
                    sum = sum +100;
                }
                
            }else if(arr[i] == 'L'){
                sum = sum +50;
            }else if(arr[i] == 'X'){
                if(i+1 != arr.length && arr[i+1] == 'C'){
                    sum+=90;
                    i=i+2;
                    continue;
                }else if(i+1 != arr.length && arr[i+1] == 'L'){
                    sum+=40;
                    i=i+2;
                    continue;
                }else{
                    sum = sum +10;
                }
            }
            else if(arr[i] == 'V'){
                sum = sum +5;
            }else if(arr[i] == 'I'){
                
                if(i+1 != arr.length){
                    if(arr[i+1] == 'X'){
                        sum+=9;
                        i=i+2;
                        continue;
                    }else if(arr[i+1] == 'V'){
                        sum+=4;

                        i=i+2;
                        continue;
                    }else{
                            sum+=1;
                    }
                    
                }else{
                    sum+=1;
                }
            }
            i++;

        }
        return sum;
    }
}