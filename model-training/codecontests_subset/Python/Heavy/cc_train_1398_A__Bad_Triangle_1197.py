import sys
import math
import time
from functools import lru_cache
from collections import Counter
import heapq
#@lru_cache(maxsize=None) #for optimizing the execution time of callable objects/functions(placed above callable functions)
def pw(a,b,m):
    a%=m
    ans=1
    if a==0:return 0
    while(b>0):
        if(b&1):
            ans=(ans*a)%m
        b=b//2
        a=(a*a)%m
    return ans

try:
    for _ in range(int(input())):
        n=int(input())
        arr=[int(i) for i in input().split()]
        ans=arr[0]+arr[1]
        flg=0;pos=0
        for i in range(2,n):
            if ans<=arr[i]:
                flg=1
                pos=i
                break
        if flg==0:
            print(-1)
        else:
            print(1,2,pos+1)
                
                
        
        
        
                
        
except EOFError as e:
    print(e)
