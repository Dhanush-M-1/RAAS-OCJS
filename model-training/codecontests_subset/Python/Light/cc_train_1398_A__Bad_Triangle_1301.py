from math import *
sInt = lambda: int(input())
mInt = lambda: map(int, input().split())
lInt = lambda: list(map(int, input().split()))

t= sInt()


for _ in range(t):
    n = sInt()
    a = lInt()
    if a[0]+a[1]>a[-1]:
        print(-1)
    else:
        print(1,2,n)

















