# -*- coding: utf-8 -*-
"""
Created on Tue Oct 20 20:24:07 2020

@author: jion
"""

t = int(input())
for i in range(t):
    m = n = int(input())
    if n == 1:
        print(0)
    else:
        a = 0
        while True:
            if m % 3 == 0:
                m = m//3
                a += 1
            else:
                break
        if a > 0:
            import math
            b = math.log(n//(3**a),2)
            if (b % 1 == 0 or b == 0) and a >= b:
                print(2*a - int(b))
            else:
                print(-1)
        else:
            print(-1)