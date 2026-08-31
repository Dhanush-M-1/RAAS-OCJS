import math as mt 
import sys,string
input=sys.stdin.readline
#print=sys.stdout.write
L=lambda : list(map(int,input().split()))
Ls=lambda : list(input().split())
M=lambda : map(int,input().split())
I=lambda :int(input())
from collections import defaultdict


t=I()
for _ in range(t):
    x=I()
    n=x
    c=0
    d=0
    while(x%2==0):
        c+=1
        x//=2
    while(x%3==0):
        d+=1
        x//=3
    if(x>1):
        print(-1)
    else:
        if(c>d):
            print(-1)
        elif(c==d):
            if(n==1):
                print(0)
            else:
                print(c)
        else:
            print((d-c)+d)
        
    
    

