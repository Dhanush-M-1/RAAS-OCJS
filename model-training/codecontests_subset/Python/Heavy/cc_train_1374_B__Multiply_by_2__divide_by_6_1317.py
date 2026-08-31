import math
from sys import stdin
from collections import Counter,defaultdict,deque
input=stdin.readline
mod=pow(10,9)+7
def solve():
    n=int(input())
    c1=0
    c2=0
    while(1):
        flag=0
        if(n%3==0):
            c2+=1
            n=n//3
            flag=1
        if(n%2==0):
            c1+=1
            n=n//2
            flag=1
        if(flag==0):
            break
    if(c1>c2 or n>1):
        print(-1)
    elif(c1==c2):
        print(c1)
    else:
        x=c2-c1
        print(c1+2*x)
    
    
for _ in range(int(input())):
    solve()