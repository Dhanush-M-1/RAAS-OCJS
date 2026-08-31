import io
import os
import sys
import math
import heapq


input = sys.stdin.readline
mod = 10**9 + 7
 
t = int(input())


for _ in range(t):
    n = int(input())
    G = []
    for _ in range(n):
        x = input().rstrip()
        x = list(x)
        G.append(x)
        
    #print(G)
    
    s1,s2 = int(G[0][1]), int(G[1][0])
    f1,f2 = int(G[n-2][n-1]), int(G[n-1][n-2])
    
    if s1+s2 == 2:
        s = f1+f2
        print(s)
        if f1 == 1:
            print(n-1, n)
        if f2 == 1:
            print(n, n-1)
            
    elif s1+s2 == 0:
        s = 2 - (f1+f2)
        print(s)
        if f1 == 0:
            print(n-1, n)
        if f2 == 0:
            print(n, n-1)
            
    else:
        if f1+f2>0:
            s = 2 - (f1+f2) + 1
            print(s)
            if f1 == 0:
                print(n-1, n)
            if f2 == 0:
                print(n, n-1)
            if s1 == 1:
                print(1,2)
            if s2==1:
                print(2,1)
        else:
            s = 2 - (s1+s2)
            print(s)
            if s1==0:
                print(1,2)
            if s2==0:
                print(2,1)
        
