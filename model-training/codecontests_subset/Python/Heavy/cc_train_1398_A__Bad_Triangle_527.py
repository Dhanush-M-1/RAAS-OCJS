# -*- coding: utf-8 -*-
"""
Created on Tue Aug 18 00:52:21 2020

@author: RACHIT
"""


def triplet(arr:list):
    if len(arr)==0:
        return [-1]
    if len(arr)==3:
        if arr[-1]>=arr[0]+arr[1]:
            return[1,2,3]
        return [-1]
    for i in range(len(arr)-1,2,-1):
        if arr[i]>arr[0]+arr[1]:
            return [1,2,i+1]
    return [-1]

if __name__=="__main__":
    t=int(input())
    while(t>0):
        x=int(input())
        arr=[int(i) for i in input().split()]
        ans=triplet(arr)
        for j in ans:
            print(j,end=' ')
        print()
        t-=1

'''
4 6 11 11 15 18 20
10 10 10 11
1 1 100000'''