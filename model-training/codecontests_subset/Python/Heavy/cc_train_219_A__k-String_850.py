#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Apr  2 04:27:36 2020

@author: maruf
"""


n = int(input())
s = sorted(input())
st = s[::n]*n
if sorted(st)==s:
    print("".join(st))
else:
    print(-1)


'''
occ_list=[]
j=0
k=int(input())
s=input()
str_list=list(s)
uniqe_list=list(set(str_list))
for i in range(len(uniqe_list)):
    j=str_list.count(uniqe_list[i])
    occ_list.append(j)

occ_list=set(occ_list)
#print(len(occ_list))
#if(isPowerOfTwo(k)):
if(len(occ_list)==1):
        print(("".join(uniqe_list))*k)
else:
        print("-1")
        
#else:
#    print("-1")
   
'''

