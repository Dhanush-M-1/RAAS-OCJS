import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,copy,functools
# import time,random,resource

# sys.setrecursionlimit(10**7)
inf = 10**20
eps = 1.0 / 10**10
mod = 10**9+7
mod2 = 998244353
dd = [(-1,0),(0,1),(1,0),(0,-1)]
ddn = [(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1),(0,-1),(-1,-1)]

def LI(): return list(map(int, sys.stdin.readline().split()))
def LLI(): return [list(map(int, l.split())) for l in sys.stdin.readlines()]
def LI_(): return [int(x)-1 for x in sys.stdin.readline().split()]
def LF(): return [float(x) for x in sys.stdin.readline().split()]
def LS(): return sys.stdin.readline().split()
def I(): return int(sys.stdin.readline())
def F(): return float(sys.stdin.readline())
def S(): return input()
def pf(s): return print(s, flush=True)
def pe(s): return print(str(s), file=sys.stderr)
def JA(a, sep): return sep.join(map(str, a))
def JAA(a, s, t): return s.join(t.join(map(str, b)) for b in a)
def IF(c, t, f): return t if c else f
def YES(c): return IF(c, "YES", "NO")
def Yes(c): return IF(c, "Yes", "No")


def main():
    t = I()

    rr = []
    for _ in range(t):
        n = I()
        a = LI()

        if set(a) == 1:
            rr.append("0 1")
            continue

        l = inf
        r = 0
        for b,c in zip(a,a[1:]):
            if c < b:
                b,c = c,b
            if b != -1 or c == -1:
                continue
            l = min(c, l)
            r = max(c, r)

        if l == inf:
            l = 10

        t = (l+r) // 2
        for i in range(n):
            if a[i] < 0:
                a[i] = t

        s = 0
        for b,c in zip(a,a[1:]):
            u = abs(b-c)
            if s < u:
                s = u

        rr.append(JA([s,t], " "))


    return JA(rr, "\n")


print(main())


