import sys
import math
# sys.stdin=open('input.txt','r')
# sys.stdout=open('output2.txt','w')
from sys import stdin,stdout
from collections import deque,defaultdict
from math import ceil,floor,inf,sqrt,factorial,gcd,log2
from copy import deepcopy
ii1=lambda:int(stdin.readline().strip())
is1=lambda:stdin.readline().strip()
iia=lambda:list(map(int,stdin.readline().strip().split()))
isa=lambda:stdin.readline().strip().split()
mod=1000000007
def factor(n):
    arr=[0]*2
    while n%2==0:
        arr[0]+=1
        n//=2
    while n%3==0:
        arr[1]+=1
        n//=3
    if n>1:
        arr.append(n)
    return arr
for _ in range(ii1()):
    n = ii1()
    if n==1:
        print(0)
        continue
    if n==3:
        print(2)
        continue
    if bin(n).count('1')==1:
        print(-1)
        continue
    arr=factor(n)
    if len(arr)==2 and (arr[0]>0 or arr[1]>0):
        # print(arr)
        if arr[0]==arr[1]:
            print(arr[0])
        elif arr[0]>arr[1]:
            print(-1)
        else:
            print(arr[1]+arr[1]-arr[0])
    else:
        print(-1)
