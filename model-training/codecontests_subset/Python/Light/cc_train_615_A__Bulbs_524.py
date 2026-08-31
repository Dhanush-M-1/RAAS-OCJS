# -*- coding: utf-8 -*-
"""
Created on Wed Feb  5 13:02:39 2020

@author: CheongRoach
"""

n, m = map(int, input().split(' '))
tot = set()
for _ in range(n):
    nums = list(map(int, input().split(' ')))[1:]
    tot |= set(nums)
print("YES" if len(tot) == m else 'NO')
	 	 	   		 	 	  	    	      	 	