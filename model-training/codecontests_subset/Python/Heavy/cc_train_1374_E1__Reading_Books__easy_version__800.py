import math
from collections import Counter,deque
L=lambda:list(map(int,input().split()))
M=lambda:map(int,input().split())
I=lambda:int(input())
IN=lambda:input()
mod=10**9+7
def s(a):
    print(" ".join(list(map(str,a))))
#______________________-------------------------------_____________________#
def solve():
    n,k=M()
    a=[];b=[]
    d=[]
    for i in range(n):
        t,x,y=M()
        if x+y==2:
            d.append(t)
        elif x==1:
            a.append(t)
        elif y==1:
            b.append(t)
    a.sort()
    b.sort()
    for i in range(min(len(a),len(b))):
        d.append((a[i]+b[i]))
    if len(d)<k:
        print(-1)
    else:
        d.sort()
        print(sum(d[:k]))
for i in range(1):
    solve()
