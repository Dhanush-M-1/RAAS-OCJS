import sys
from collections import defaultdict
input = lambda:sys.stdin.readline().strip()
n,k = map(int,input().split())
a = []
b = []
c = []
for i in range(n):
    ti,ai,bi = map(int,input().split())
    if ai==0 and bi==1:
        a.append(ti)
    elif ai==1 and bi==0:
        b.append(ti)
    elif ai==1 and bi==1:
        c.append(ti)
a.sort()
b.sort()
c.sort()
for i in range(1,len(a)):
    a[i]+=a[i-1]
for i in range(1,len(b)):
    b[i]+=b[i-1]
for i in range(1,len(c)):
    c[i]+=c[i-1]
c = [0]+c
# print(a,b,c)
ans = float('inf')
for i in range(len(c)):
    rem = k-i
    if i==k:
        ans = min(ans,c[i])
    if rem-1>=0 and rem<=min(len(a),len(b)):
        ans = min(ans,c[i]+a[rem-1]+b[rem-1])
if ans==float('inf'):
    print(-1)
else:
    print(ans)
    