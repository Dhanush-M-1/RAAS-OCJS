# import io, os
# input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
import sys
# sys.stdin=open('input.txt','r')
# sys.stdout=open('output.txt','w')
input=sys.stdin.readline
# sys.setrecursionlimit(300010)
MOD = 1000000007
MOD2 = 998244353
ii = lambda: int(input().strip('\n'))
si = lambda: input().strip('\n')
dgl = lambda: list(map(int,input().strip('\n')))
f = lambda: map(int, input().strip('\n').split())
il = lambda: list(map(int, input().strip('\n').split()))
ls = lambda: list(input().strip('\n'))
lsi = lambda: [int(i) for i in ls()]
let = 'abcdefghijklmnopqrstuvwxyz'
for _ in range(1):
    n,k=f()
    l=il()
    mx=max(l)
    cost=[[] for i in range(mx+1)]
    for i in l:
        x=0
        while i>0:
            cost[i].append(x)
            x+=1
            i//=2
        cost[0].append(x)
    mn=10**15
    for i in range(mx+1):
        if len(cost[i])>=k:
            cost[i].sort()
            mn=min(mn,sum(cost[i][:k]))
    print(mn)