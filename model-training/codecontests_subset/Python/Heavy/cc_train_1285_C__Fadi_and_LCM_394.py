# -*- coding: utf-8 -*-
"""
Created on Tue Jan 14 19:32:10 2020

@author: Mitya
"""
a=int(input())
b=int(a**0.5)
while b>0:
    if  a%b==0:
        c=a//b
        if b==c==1:
            print(b,c)
            break
        elif b!=c:
            k=b
            l=c
            m=k*l
            while k>0 and l>0:
                if k>l:
                    k%=l
                else:
                    l%=k
            m=m//(k+l)
            if m==a:
                print(b,c)
                break
    b+=-1