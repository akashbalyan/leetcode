class Solution {
    public String intToRoman(int num) {
        String ans = "";
        int d = 1000;
        while(d>=1){
            int n = num /d;
            num = num%d;
            if(n > 0 ){
                if(d == 1000){
                    for(int i=0;i<n;i++){
                        ans = ans + "M";
                    }
                            
                }else if(d == 100){
                        if(n == 1){
                            ans+="C";
                        }else if (n == 2){
                            ans+="CC";
                        }else if (n == 3){
                            ans+="CCC";
                        }else if (n == 4){
                            ans+="CD";
                        }else if (n == 5){
                            ans+="D";
                        }else if (n == 6){
                            ans+="DC";
                        }else if (n == 7){
                            ans+="DCC";
                        }else if (n == 8){
                            ans+="DCCC";
                        }else if (n == 9){
                            ans+="CM";
                        }
                }else if(d == 10){
                    if(n == 1){
                    ans+="X";
                    }else if(n == 2){
                        ans+="XX";
                    }else if(n == 3){
                        ans+="XXX";
                    }else if(n == 4){
                        ans+="XL";
                    }else if(n == 5){
                        ans+="L";
                    }else if(n == 6){
                        ans+="LX";
                    }else if(n == 7){
                        ans+="LXX";
                    }else if(n == 8){
                        ans+="LXXX";
                    }else if(n == 9){
                        ans+="XC";
                    }
                }else {
                    if(n == 1){
                    ans+="I";
                    }else if(n == 2){
                        ans+="II";
                    }else if(n == 3){
                        ans+="III";
                    }else if(n == 4){
                        ans+="IV";
                    }else if(n == 5){
                        ans+="V";
                    }else if(n == 6){
                        ans+="VI";
                    }else if(n == 7){
                        ans+="VII";
                    }else if(n == 8){
                        ans+="VIII";
                    }else if(n == 9){
                        ans+="IX";
                    }
                }
            
                
            }
            d = d/10;
        }
        return ans;
    }
}