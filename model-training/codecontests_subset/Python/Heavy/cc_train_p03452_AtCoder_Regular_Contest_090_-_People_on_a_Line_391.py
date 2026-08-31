import sys
def input(): return sys.stdin.readline().strip()
N,M=map(int,input().split())
P=[list(map(int,input().split())) for i in range(M)]
inf=10**15
c=[[] for i in range(N)]
for i,j,w in P:
    c[i-1].append((j-1,w))
    c[j-1].append((i-1,-w))
d=[inf]*N
v=[0]*N
a=0
import sys
sys.setrecursionlimit(10**7)
def dfs(p,v,d):
    for n,w in c[p]:
        if v[n]==0:
            d[n]=d[p]+w
            v[n]=1
            if dfs(n,v,d)==-1:
                return -1
        elif d[p]+w!=d[n]:
            return -1
    return 0
s=0
while True:
    d[s]=0
    v[s]=1
    a=dfs(s,v,d)
    if a<0:
        break
    try:
        s=d.index(inf,s)
    except ValueError:
        break
print(['Yes','No'][a])