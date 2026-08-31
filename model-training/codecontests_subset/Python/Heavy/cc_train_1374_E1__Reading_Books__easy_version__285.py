import sys
input = sys.stdin.readline
from collections import *

n, k = map(int, input().split())
d = defaultdict(list)

for _ in range(n):
    t, a, b = map(int, input().split())
    
    if a==1 and b==1:
        d[0].append(t)
    elif a==1 and b==0:
        d[1].append(t)
    elif a==0 and b==1:
        d[2].append(t)
 
acc = defaultdict(list)

for i in range(3):
    d[i].sort()
    acc[i].append(0)
    
    for ti in d[i]:
        acc[i].append(acc[i][-1]+ti)

ans = 10**18

for i in range(min(k, len(d[0]))+1):
    if k-i>len(d[1]) or k-i>len(d[2]):
        continue
    
    ans = min(ans, acc[0][i]+acc[1][k-i]+acc[2][k-i])

if ans==10**18:
    print(-1)
else:
    print(ans)