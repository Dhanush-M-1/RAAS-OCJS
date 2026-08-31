import math,sys
from sys import stdin, stdout
from collections import Counter, defaultdict, deque
input = stdin.readline
I = lambda:int(input())
li = lambda:list(map(int,input().split()))

def solve():
    n=I()
    c=0
    a=[]
    while(n%2==0):
        n=n//2
        c+=1
    d=0
    while(n%3==0):
        n=n//3
        d+=1
    if(c>d):
        print(-1)
    else:
        if(n!=1):
            print(-1)
        else:
            print((d-c)+d)

        
    
    
for _ in range(I()):
    solve()