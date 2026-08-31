# -*- coding: utf-8 -*-
"""
Created on Sun Jan 19 10:44:15 2020

@author: Mridul Garg
"""

def besty(s):
    s = list(s)
#    print(type(s))
    for top in range(len(s)):
        best = s[top]
        index = top
        for i in range(len(s)-1, top-1, -1):
            if s[i] < best:
                best = s[i]
                index = i
        
        if index == top:
            continue
        else:
            s[top], s[index] = s[index], s[top]
            break
    return s
        

q = int(input())

for _ in range(q):
    s ,c  = input().split(" ")
#    s = list(s)
    
    
    s = besty(s)
#    for top in range(len(s)):
#        best = s[top]
#        index = top
#        for i in range(top, len(s)):
#            if s[i] < best:
#                best = s[i]
#                index = i
#        
#        if index == top:
#            continue
#        else:
#            s[top], s[index] = s[index], s[top]
#            break
#        
#    for i in range(min(len(s), len(c))):
    temp = ""
    s = temp.join(s)
    
#    print(s, c)
    
    if s < c:
        print(s)
        
    else:
#        print("heloo")
        print("---")
                