n,m=map(int,input().split())
from collections import defaultdict
d=defaultdict(int)
cond=True
for i in range(1,m+1):
    d[i]=0
for _ in range(n):
    arr=list(map(int,input().split()))
    arr.pop(0)
    for num in arr:
        d[num]+=1
for val in d.values():
    if val==0:
        print("NO")
        cond=False
        break
if cond:
    print("YES")
