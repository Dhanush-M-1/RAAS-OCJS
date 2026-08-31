from decimal import *
getcontext().prec=16
from math import sqrt

t=int(input())

answer=[]
for test in range(t):
    n=int(input())
    liste=list(map(int,input().split(" ")))
    a,b=liste[0],liste[1]
    for k in range(2,n):
        if liste[k]>=a+b:
            answer.append("1 2 "+str(k+1))
            break
    else:
        answer.append("-1")


print(("\n").join(answer))