import sys
reader = (s.rstrip() for s in sys.stdin)
input = reader.__next__

class RangeMinimumQuery:
    def __init__(self, n, inf=float("inf")):
        self.n0 = 2**(n-1).bit_length()
        self.inf = inf
        self.data = [self.inf]*(2*self.n0) 
        self.cnt = [0]*(2*self.n0)

    def query(self, l,r):
        l += self.n0
        r += self.n0
        res = 0
        cnt = 0
        while l < r:
            if r&1:
                r -= 1
                res += self.data[r-1]
                cnt += self.cnt[r-1]
            if l&1:
                res += self.data[l-1]
                cnt += self.cnt[l-1]
                l += 1
            l >>=1
            r >>=1
        return res, cnt

    def update(self, i, x):
        i += self.n0-1
        self.data[i] += x
        self.cnt[i] += 1
        while i:
            i = ~-i//2
            self.data[i] = self.data[2*i+1] + self.data[2*i+2]
            self.cnt[i] = self.cnt[2*i+1] + self.cnt[2*i+2]

n = int(input())
xs = list(map(int, input().split()))
vs = list(map(int, input().split()))

xv = [[x,v] for x,v in zip(xs,vs)]
xv.sort()
d = sorted(set(vs))
dd = {j:i for i,j in enumerate(d)}
m = len(dd)

RSQ = RangeMinimumQuery(m, 0)

ans = 0
for x, v in xv:
    nv = dd[v]
    su, cnt = RSQ.query(0, nv+1)
    ans += cnt*x - su
    RSQ.update(nv, x)
print(ans)
