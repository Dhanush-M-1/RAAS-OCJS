def line():
    return map(int, input().split())

def num():
    return int(input())

from itertools import repeat
from math import inf

t = num()
for _ in repeat(None, t):
    n = num()
    a = list(line())
    m1 = 0
    qmin,qmax = inf,-1
    for i in range(n):
        if a[i]==-1:
            if i-1>=0 and a[i-1]!=-1:
                qmin = min(qmin, a[i-1])
                qmax = max(qmax, a[i-1])
            if i+1<n and a[i+1]!=-1:
                qmin = min(qmin, a[i+1])
                qmax = max(qmax, a[i+1])
        else:
            if i-1>=0 and a[i-1]!=-1:
                m1 = max(m1,abs(a[i]-a[i-1]))
            if i+1<n and a[i+1]!=-1:
                m1 = max(m1, abs(a[i] - a[i+1]))
    k = (qmin+qmax)//2
    m2 = max(k-qmin,qmax-k)
    if all(x==-1 for x in a):
        print(0,0)
    else:
        print(max(m1,m2),k)
