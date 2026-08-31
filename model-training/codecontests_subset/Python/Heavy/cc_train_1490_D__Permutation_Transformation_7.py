# -*- coding: utf-8 -*-
"""
Created on Wed Apr 15 17:39:13 2020

@author: pena
"""

# -*- coding: utf-8 -*-
"""
Created on Fri Apr  3 17:34:50 2020

@author: pena
"""
import sys
import math


t = int(input())
    
def cond(a,b):
    return (max(a,b) / min(a,b))

def solve2(nums,n):
    ans = 0
    maxind = nums.index(max(nums))
    nind = nums.index(n)
  #  print(nums)
  #  print(n)
    if nind == maxind:
         return ans
    elif nind > maxind:
        return 1 + solve2(nums[maxind+1:],n)
    elif nind < maxind:
        return 1 + solve2(nums[0:maxind],n)
    
def solve(nums,n):
    ans = []
    for i in range(n):
        sys.stdout.write("" + str(solve2(nums,nums[i])) + " ")
    sys.stdout.write("\n")
    
for i in range(t):
    n = int(input())
    numss = input().split()
    nums = [int(i) for i in numss]
    solve(nums,n)