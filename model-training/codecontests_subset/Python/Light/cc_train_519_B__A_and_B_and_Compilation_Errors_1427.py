# -*- coding: utf-8 -*-
"""
Created on Thu Sep 17 23:25:39 2020
519B  A and B and Compilation Errors
@author: RACHIT
"""
if __name__=="__main__":
    n=int(input())
    l=list(map(int,input().split()))
    l1=list(map(int,input().split()))
    l2=list(map(int,input().split()))
    print(sum(l)-sum(l1))
    print(sum(l1)-sum(l2))
    
    
    