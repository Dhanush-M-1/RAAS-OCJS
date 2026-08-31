from collections import deque
from math import ceil,floor,sqrt,gcd
def ii(): return int(input())
def mi(): return map(int,input().split())
def li(): return list(mi())
def si():return input()
a,b=mi()
c=a//b
s=a
c=0
for i in range(1,a+1):
    if(i%b==0):
        c+=1
while(c):
    s1=s
    s+=c
    c=0
    for i in range(s1+1,s+1):
        if(i%b==0):
            c+=1
print(s)