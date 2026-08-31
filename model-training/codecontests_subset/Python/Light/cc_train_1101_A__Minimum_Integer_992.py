#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Jan 11 20:47:40 2019

@author: adarsha
"""

tes=int(input())
for t in range(tes):
    a = [int(x) for x in input().split()]
    li=a[0]
    ri=a[1]
    di=a[2]
    done=1
    i=1
    if di>ri:
        xi=di
    elif di<li:
        xi=di
    else:
        z=ri//di
        xi=di*(z+1)
    print(xi)