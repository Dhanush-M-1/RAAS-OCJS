# -*- coding: utf-8 -*-
"""
Created on Sat Feb  8 10:53:14 2020

@author: Mohsen
"""

def isSharpning(numbers):
    
    for i in range(0,len(numbers)):
        numbers[i] = numbers[i] - min(i, len(numbers) - i - 1);
    
    if min(numbers) < 0:
        return False; 
    if len(numbers)%2 == 0 and numbers[int(len(numbers)/2) - 1] == 0 and numbers[int(len(numbers)/2)] == 0:
        return False;
    
    return True;


t = int(input());

for ti in range(0,t):
    n = int(input());
    numbers =list(map(int, (input().split())));
    
    if (isSharpning(numbers)):
        print("Yes");
    else:
        print("No");
        
