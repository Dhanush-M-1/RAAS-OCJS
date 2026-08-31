#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Jun 14 10:28:21 2020

@author: shailesh
"""


def find_power_of(num,base):
    count = 0
    while(num%base == 0):
        num //= base
        count +=1
    return num,count



a,b = [int(i) for i in input().split()]


a,a5 = find_power_of(a,5)
b,b5 = find_power_of(b,5)

a,a3 = find_power_of(a,3)
b,b3 = find_power_of(b,3)

a,a2 = find_power_of(a,2)
b,b2 = find_power_of(b,2)


if a!=b:
    print(-1)
else:
    count = abs(a5-b5) + abs(a3-b3) + abs(a2-b2)
    print(count)