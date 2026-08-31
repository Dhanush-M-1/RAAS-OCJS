#Problem F Shreyansh
from math import *

t=int(input())
while t:
    t=t-1
    #n,m=map(int,input().split())
    n=int(input())
    a=list(map(int,input().split()))
    s=a[0]+a[1]
    flag=1
    for i in range(2,n):
        if s<=a[i]:
            print(1,2,i+1)
            flag=0
            break
    if flag:
        print(-1)
    
    
        
        
