import sys
import math
import collections
import heapq
import decimal
input=sys.stdin.readline
n,a,b,c=(int(i) for i in input().split())
c1=0
for i in range(a+1):
    for j in range(b+1):
        k=(n-0.5*i-j)/2
        if(k>=0 and k<=c and k==int(k)):
            c1+=1
print(c1)