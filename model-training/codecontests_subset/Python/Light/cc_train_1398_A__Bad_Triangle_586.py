import sys #another one
inp=sys.stdin.buffer.readline
inin=lambda : int(inp())
inar=lambda typ=int: list(map(typ,inp().split()))
inst=lambda : inp().decode().strip()
_T_=inin()
for _t_ in range(_T_):
    n=inin()
    a=inar()
    if a[0]+a[1]>a[n-1]:
        print(-1)
    else:
        print(1,2,n)