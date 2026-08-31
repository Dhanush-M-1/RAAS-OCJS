# -*- coding: utf-8 -*-
"""
Created on Wed May 23 05:54:15 2018

@author: Arsanuos
"""

def main():
    n = int(input())
    arr = [int(t) for t in input().split()]
    arr = sorted(arr)
    val = 1
    step = 2
    cnt1 = 0
    for item in arr:
        if item != val:
            cnt1 += abs(item - val)
        val += step
    
    val = 2
    cnt2 = 0
    for item in arr:
        if item != val:
            cnt2 += abs(item - val)
        val += step
    
    print(min(cnt1, cnt2))
    
    
if __name__ == "__main__":
    main()