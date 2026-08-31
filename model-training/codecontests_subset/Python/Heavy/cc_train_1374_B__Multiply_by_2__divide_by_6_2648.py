# -*- coding: utf-8 -*-
"""
Created on Wed Jul 15 03:15:06 2020

@author: thiva
"""

t = int(input())

for i in range(t):
    n = int(input())
    twos = 0;
    threes = 0;
    
    if(n != 1):
        old_value = n
        while(old_value % 3 == 0):
            new_value = old_value // 3
            threes += 1
            old_value = new_value
        
        while(old_value % 2 == 0):
            new_value = old_value // 2
            twos += 1
            old_value = new_value
        
        if(old_value == 1):
            if(twos <= threes):
                ans = 2*threes - twos
            else:
                ans = -1
        else:
            ans = -1
    else:
        ans = 0
        
    print(ans)