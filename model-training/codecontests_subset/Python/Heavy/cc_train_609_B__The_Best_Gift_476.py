#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Jun 19 12:21:39 2020

@author: shailesh
"""

n,m = [int(i) for i in input().split()]

A = [int(i) for i in input().split()]

m_arr = [0 for i in range(m+1)]

for i in A:
    m_arr[i] +=1

A = m_arr[1:]

prefix_arr = []

curr_sum = 0
for i in A:
    curr_sum +=i
    prefix_arr.append(curr_sum)

total_val = 0

for i in range(len(prefix_arr)-1):
    
    total_val += A[i] *(prefix_arr[-1] - prefix_arr[i])
#    print(total_val)
print(total_val)