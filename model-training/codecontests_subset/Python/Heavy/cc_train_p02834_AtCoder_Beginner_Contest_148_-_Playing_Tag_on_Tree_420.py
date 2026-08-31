import sys,collections,math,random;sys.setrecursionlimit(10**7)
from fractions import gcd
def Is(): return [int(x) for x in sys.stdin.readline().split()]
def Ss(): return sys.stdin.readline().split()
def I(): return int(sys.stdin.readline())
def S(): return input()

n,u,v = Is()
tree = [[] for _ in range(n)]
for _ in range(n-1):
    a,b = Is()
    tree[a-1].append(b-1)
    tree[b-1].append(a-1)

md_u, md_v = [-1]*n, [-1]*n
qs = [[u-1,0]], [[v-1,0]]
for md,q in zip([md_u,md_v],qs):
    while q:
        n,d = q.pop()
        md[n] = d
        for e in tree[n]:
            if md[e] == -1:
                q.append([e,d+1])
#print(md_u,md_v)
ans = -2
for a,b in zip(md_u,md_v):
    if a < b:
        ans = max(b,ans)
print(ans-1)
