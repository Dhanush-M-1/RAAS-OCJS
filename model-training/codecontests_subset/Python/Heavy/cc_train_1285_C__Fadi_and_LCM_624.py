#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Jan 10 15:29:56 2020

@author: dennis
"""

import math

def lcm(a, b):
    return abs(a*b) // math.gcd(a, b)

def isPrime(n): 
    if (n <= 1) : 
        return False
    if (n <= 3) : 
        return True
    if (n % 2 == 0 or n % 3 == 0) : 
        return False
    i = 5
    while(i * i <= n) : 
        if (n % i == 0 or n % (i + 2) == 0) : 
            return False
        i = i + 6
    return True

def main(x):
    a = int(math.sqrt(x))
    while True:
        if x%a == 0:
            b = x//a
            if lcm(a, b) == x:
                break
        a -= 1
    return (a, b)

x = int(input())
if isPrime(x):
    print(1, x)
else:
    solution = main(x)
    print(min(solution), max(solution))
