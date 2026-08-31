import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time,copy,functools

sys.setrecursionlimit(10**7)
inf = 10**20
eps = 1.0 / 10**10
mod = 10**9+7
dd = [(-1,0),(0,1),(1,0),(0,-1)]
ddn = [(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1),(0,-1),(-1,-1)]

def LI(): return [int(x) for x in sys.stdin.readline().split()]
def LI_(): return [int(x)-1 for x in sys.stdin.readline().split()]
def LF(): return [float(x) for x in sys.stdin.readline().split()]
def LS(): return sys.stdin.readline().split()
def I(): return int(sys.stdin.readline())
def F(): return float(sys.stdin.readline())
def S(): return input()
def pf(s): return print(s, flush=True)


def main():
    n,m,k = LI()
    aa = [[c for c in S()] for _ in range(n)]

    def search(s):
        d = collections.defaultdict(lambda: inf)
        d[s] = 0
        q = []
        heapq.heappush(q, (0, s))
        v = collections.defaultdict(bool)
        while len(q):
            k, u = heapq.heappop(q)
            if v[u]:
                continue
            v[u] = True
            cy = u[0]
            cx = u[1]

            for dy,dx in dd:
                ny = cy + dy
                nx = cx + dx
                uv = (ny,nx)
                if v[uv] or ny < 0 or ny >= n or nx < 0 or nx >= m or aa[ny][nx] == '#':
                    continue
                vd = k + 1
                if d[uv] > vd:
                    d[uv] = vd
                    heapq.heappush(q, (vd, uv))

        return d

    s = None
    for i in range(n):
        for j in range(m):
            if aa[i][j] == '.':
                s = (i,j)
                break
        if s:
            break

    d = search(s)
    va = sorted(d.items(), key=lambda x: [-x[1], x[0]])
    for t,v in va[:k]:
        i,j = t
        aa[i][j] = 'X'

    return '\n'.join(map(lambda x: ''.join(x), aa))


print(main())


