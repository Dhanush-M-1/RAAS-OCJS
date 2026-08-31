# cook your dish here

I = lambda : int(input())
In = lambda : list(map(int,input().split()))
from collections import Counter
n = I()
a = Counter(In())
b = Counter(In())
c = Counter(In())

d = a - b
res = []
for x in d:
    if d[x] > 0:
        res.append(x)
e = b - c
for x in e:
    if e[x] > 0:
        res.append(x)
for x in res:
    print(x)
