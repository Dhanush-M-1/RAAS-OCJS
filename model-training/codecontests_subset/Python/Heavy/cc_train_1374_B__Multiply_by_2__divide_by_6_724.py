'''
Author : Shubhanshu Jain;
'''

import math
import random;
from collections import * 
mod =1000000007
r1 = lambda : int(input());
rm = lambda : map(int,input().split());
rms = lambda : map(str,input().split());
rls = lambda : list(rm())


def def_value(): 
	return "nan"
	

    
def solve():
    test = r1();
    while(test):
        test-=1;
        n = r1();
        flag = True;
        ans = 0;
        while(n>1):
            if(n%6==0):
                n=n//6;
            else:
                if(n%6!=3):
                    flag = False;
                    break;
                else:
                    n*=2;
            ans+=1;
        if(flag ):
            print(ans);
        else:
            print(-1)
	
solve();

