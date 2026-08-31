from collections import deque
from math import sqrt,ceil
def ii(): return int(input())
def si(): return input()
def mi(): return map(int,input().strip().split(" "))
def li(): return list(mi())
def isprime(n):
    if(n==1):
        return 0
    for i in range(2,int(sqrt(n))+1):
        if(n%i==0):
            return 0
    return 1
n=ii()
a=li()
s=sum(a)
s1=0
x=max(a)
for i in a:
    s1+=x-i
if(s>=s1):
    y=s-s1
    y=ceil(y/n)
    s1+=(y*n)
    if(s==s1):
        y+=1
    print(x+y)
else:
    print(x)