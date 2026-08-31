# -*- coding: utf-8 -*-
"""
Created on Wed Jan 15 22:53:45 2020

@author: Mridul Garg
"""

#x = [1, 2, 3]
#x.append(x)
#x[3][3][3][3][0] = 5
#print(x)
import math


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a%b)

n = int(input())

ma = n

le = int(math.sqrt(n)) 
#print(le)

for i in range(1, 1+ le):
    if n%i == 0:
        a = i
        b = n//i
        temp = gcd(a, b)
        if temp == 1:
            if max(a, b) < ma:
                ma = max(a, b)
                
print(ma, n//ma)