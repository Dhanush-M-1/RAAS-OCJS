MOD = 1000000007
ii = lambda :  int(input())
si = lambda :  input()
dgl = lambda : list(map(int, input()))
f = lambda :   map(int, input().split())
il = lambda :  list(map(int, input().split()))
ls = lambda :  list(input())
from collections import Counter
for _ in range(ii()):
    n=ii()
    a=il()
    if(a[0]+a[1]>a[n-1]):
        print(-1)
    else:
        print(1,2,n)
        