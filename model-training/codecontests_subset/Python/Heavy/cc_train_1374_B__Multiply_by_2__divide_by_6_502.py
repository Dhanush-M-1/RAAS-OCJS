# -*- coding: utf-8 -*-
"""
Created on Thu Aug 27 00:13:42 2020
1374B  Multiply by 2, divide by 6
@author: RACHIT
"""

if __name__=="__main__":
    t=int(input())
    while(t):
        c=0
        ans=True
        n=int(input())
        while(n!=1):
            if(n%6==0):
                n/=6
                c+=1
            elif n%6==3:
                n*=2
                c+=1
            else:
                print(-1)
                ans=False
                break
        if ans:
            print(c)
        t-=1
        


