from sys import *
from math import *
n,k= map(int, stdin.readline().split())
x,y,z=[],[],[]
for i in range(n):
    t,a,b= map(int, stdin.readline().split())
    if a and b :
        z.append(t)
    elif a:
        x.append(t)
    elif b:
        y.append(t)
x.sort()
y.sort()
for i in range(min(len(x),len(y))):
    z.append(x[i]+y[i])
z.sort()
if len(z)<k:
    print(-1)
else:
    ans=0
    for i in range(k):
        ans+=z[i]
    print(ans)