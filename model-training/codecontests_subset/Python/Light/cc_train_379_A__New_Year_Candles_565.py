#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Apr  8 11:30:18 2019

@author: xungao
"""

a,b =(map(int, input().split()))
rest = a
num = a
while(rest>=b):
    num += rest//b
    rest = rest//b+rest%b
print(num)