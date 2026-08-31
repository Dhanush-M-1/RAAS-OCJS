import heapq,math
from collections import defaultdict,deque
from os import getcwd

import sys, os.path
#sys.setrecursionlimit(100000000)
if(os.path.exists('D:\CP\programs\input.txt')):
    sys.stdout = open('D:\CP\programs\output.txt', 'w')
    sys.stdin = open('D:\CP\programs\input.txt', 'r')

input=sys.stdin.readline




test=int(input())
for _ in range(test):
    input()
    k,n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    i=j=0
    res=[0]*(n+m)
    flag=True
    idx=0
    while(i<n and j<m):
        if(a[i]<=b[j]):
            if(a[i]>k):
                flag=False
                break
            res[idx]=a[i]
            if(a[i]==0):
                k+=1
            i+=1
            idx+=1
        else:
            if(b[j]>k):
                flag=False
                break
            res[idx]=b[j]
            if(b[j]==0):
                k+=1
            j+=1
            idx+=1
    #print(flag)
    while(i<n and flag==True):
        if(a[i]>k):
            flag=False
            break
        else:
            res[idx]=a[i]
            if(a[i]==0):
                k+=1
            i+=1
            idx+=1
    while(j<m and flag==True):
        if(b[j]>k):
            #print(b[j],k)
            flag=False
            break
        else:
            res[idx]=b[j]
            if(b[j]==0):
                k+=1
            j+=1
            idx+=1
    if(flag):
        print(*res)
    else:
        print("-1")


    
