from sys import *
from math import *
b=list(input().split())
n=int(input())
m=[]
for i in range(n):
    a=list(input().split())
    m.append(a)
print(*b)
for i in range(n):
    if m[i][0]==b[0]:
        b[0]=m[i][1]
    else:
        b[1]=m[i][1]
    print(*b)