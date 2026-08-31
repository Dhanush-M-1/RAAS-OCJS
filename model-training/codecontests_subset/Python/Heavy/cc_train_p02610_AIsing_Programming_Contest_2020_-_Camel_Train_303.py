from heapq import *
import sys

sys.setrecursionlimit(10 ** 6)
int1 = lambda x: int(x) - 1
p2D = lambda x: print(*x, sep="\n")
def II(): return int(sys.stdin.readline())
def MI(): return map(int, sys.stdin.readline().split())
def LI(): return list(map(int, sys.stdin.readline().split()))
def LLI(rows_number): return [LI() for _ in range(rows_number)]
def SI(): return sys.stdin.readline()[:-1]

for _ in range(II()):
    n=II()
    ff=[]
    bb=[]
    ans=0
    for _ in range(n):
        k,l,r=MI()
        if l>r:ff.append((k,l,r))
        elif l<r:bb.append((n-k,l,r))
        else:ans+=r

    ff.sort()
    hp=[]
    for i,(k,l,r) in enumerate(ff):
        heappush(hp,l-r)
        ans+=l
        if i+1<len(ff) and ff[i+1][0]==k:continue
        while len(hp)>k:
            d=heappop(hp)
            ans-=d

    bb.sort()
    hp = []
    for i, (k, l, r) in enumerate(bb):
        heappush(hp, r-l)
        ans += r
        if i + 1 < len(bb) and bb[i + 1][0] == k: continue
        while len(hp) > k:
            d = heappop(hp)
            ans -= d

    print(ans)