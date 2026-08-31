# -*- coding: utf-8 -*-
"""
Created on Tue Oct 20 17:08:24 2020

@author: 赵泽华
"""

t=int(input())

for i in range(t):
    n=int(input())
    n2=n
    n3=n
    count=0
    count2=0
    count3=0
    while n2%2==0:
        count2+=1
        n2/=2
    while n3%3==0:
        count3+=1
        n3/=3
    if n/(2**count2)/(3**count3)!=1:
        count=-1
    elif count2==0 and count3==0 and n!=1:
        count=-1
    elif count2<=count3:
        count=count3*2-count2
    else:
        count=-1
    print(count)