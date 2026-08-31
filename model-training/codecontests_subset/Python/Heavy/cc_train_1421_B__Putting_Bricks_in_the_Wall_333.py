from math import *
from bisect import *
from collections import *
from random import *
from decimal import *
from itertools import *
import sys
input=sys.stdin.readline
def inp():
    return int(input())
def st():
    return input().rstrip('\n')
def lis():
    return list(map(int,input().split()))
def ma():
    return map(int,input().split())
t=inp()
while(t):
    t-=1
    n=inp()
    re=[]
    r=[]
    for i in range(n):
        s=st()
        s=list(s)
        re.append(s)
    li=[re[0][1],re[0][2],re[1][1],re[1][0],re[2][0]]
    for i in range(32):
        x=bin(i)[2:]
        x=x.zfill(5)
        inc=0
        for j in range(5):
            if(li[j]!=x[j]):
                inc+=1
        if(inc<=2 and (x[2]!=x[0] and x[0]!=x[1]) and (x[3]!=x[2] and x[4]!=x[3])):
            print(inc)
            for j in range(5):
                if(li[j]!=x[j]):
                    if(j==0):
                        print(1,2)
                    if(j==1):
                        print(1,3)
                    if(j==2):
                        print(2,2)
                    if(j==3):
                        print(2,1)
                    if(j==4):
                        print(3,1)
                        
        
