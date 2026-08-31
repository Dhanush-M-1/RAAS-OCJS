import math as mt 
import sys,string,bisect
input=sys.stdin.readline
from collections import deque,defaultdict
L=lambda : list(map(int,input().split()))
Ls=lambda : list(input().split())
M=lambda : map(int,input().split())
I=lambda :int(input())
def dist(x,y,c,d):
    return (x-c)**2+(y-d)**2
def circle(x1, y1, x2,y2, r1, r2): 
  
    distSq = (((x1 - x2)* (x1 - x2))+ ((y1 - y2)* (y1 - y2)))**(.5) 
  
    if (distSq + r2 <= r1): 
        return True
    else: 
        return False
a,b,c,d,e,f=M()
x=dist(a,b,c,d)
y=dist(c,d,e,f)
z=dist(e,f,a,b)
p=(c-a)*(f-b)-(d-b)*(e-a)
if(p==0):
    print("No")
else:
    if(x==y):
        print("Yes")
    else:
        print("No")
