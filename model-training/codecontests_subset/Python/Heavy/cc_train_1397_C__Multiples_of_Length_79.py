# Author : -pratyay-
import sys
inp=sys.stdin.buffer.readline
inar=lambda: list(map(int,inp().split()))
inin=lambda: int(inp())
inst=lambda: inp().decode().strip()
_T_=1
for _t_ in range(_T_):
    n=inin()
    a=inar()
    if n==1:
        print(1,1); print(-a[0]); print(1,1); print(0); print(1,1); print(0); break
    print(n,n)
    print(-a[-1])
    a[-1]-=a[-1]
    print(1,n-1)
    for i in range(n-1):
        print(a[i]*(n-1),end=' ')
        a[i]+=a[i]*(n-1)
    print()
    print(1,n)
    for i in range(n):
        print(-a[i],end=' ')
        a[i]-=a[i]
    print()