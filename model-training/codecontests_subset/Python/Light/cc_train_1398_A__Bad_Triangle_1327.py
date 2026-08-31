import sys #another one
inp=sys.stdin.buffer.readline
read=lambda typ=int: [typ(x) for x in inp().split()]
input=lambda : inp().decode().strip()
_T_,=read()
for _t_ in range(_T_):
    n,=read()
    a=read()
    if a[0]+a[1]>a[n-1]:
        print(-1)
    else:
        print(1,2,n)