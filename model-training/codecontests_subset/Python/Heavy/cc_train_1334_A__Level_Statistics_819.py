from collections import Counter
from collections import defaultdict
import math

t=int(input())
for _ in range(0,t):
    n=int(input())
    a=[]
    for i in range(0,n):
        a.append(list(map(int, input().split())))
    f=1
    x=0
    y=0
    for i in range(0,n):
        if(a[i][0]<a[i][1] or x>a[i][0] or y>a[i][1]):
            f=0
        if(x==a[i][0] and y!=a[i][1]):
            f=0
        if(abs(x-a[i][0])<abs(y-a[i][1])):
            f=0
        x=a[i][0]
        y=a[i][1]
    if(f):
        print("YES")
    else:
        print("NO")



