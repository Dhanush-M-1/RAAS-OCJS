import sys
import bisect as bi
import math
from collections import defaultdict as dd
input=sys.stdin.readline
##sys.setrecursionlimit(10**7)
def cin():
    return map(int,sin().split())
def ain():            
    return list(map(int,sin().split()))
def sin():
    return input()
def inin():
    return int(input())
for _ in range(inin()):
    n,m=cin()
    d=dd(int)
    a=ain();b=ain();f=0
    for i in a:
        d[i]=1
    for i in b:
        if(d[i]==1):
            print("YES")
            print(1,i)
            f=1
            break
    if(f==0):print("NO")
    
