MOD = 1000000007
ii = lambda :  int(input())
si = lambda :  input()
dgl = lambda : list(map(int, input()))
f = lambda :   map(int, input().split())
il = lambda :  list(map(int, input().split()))
ls = lambda :  list(input())
from collections import Counter
for _ in range(ii()):
    n,m=f()
    a=il()
    b=il()
    c=0
    for i in range(0,n):
        if(a[i] in b and c==0):
            print("YES")
            print(1,a[i])
            c=c+1
            break
    if(c==0):
        print("NO")
            