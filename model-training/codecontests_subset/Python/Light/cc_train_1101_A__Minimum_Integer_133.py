#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Jan 19 15:46:43 2019

@author: umang
"""

t = int(input())

while t > 0:
    t -= 1
    l, r, d = map(int, input().split())
    i = 1
    low = l // d
    high = r // d
    if low == 0 or low*d == l == 1*d:
        print((high+1)*d)
    else:
        print(d)
    