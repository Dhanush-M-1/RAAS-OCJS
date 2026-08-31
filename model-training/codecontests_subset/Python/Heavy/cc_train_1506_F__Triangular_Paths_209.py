import sys

sys.setrecursionlimit(10**5)
int1 = lambda x: int(x)-1
p2D = lambda x: print(*x, sep="\n")
def II(): return int(sys.stdin.buffer.readline())
def LI(): return list(map(int, sys.stdin.buffer.readline().split()))
def LI1(): return list(map(int1, sys.stdin.buffer.readline().split()))
def LLI(rows_number): return [LI() for _ in range(rows_number)]
def LLI1(rows_number): return [LI1() for _ in range(rows_number)]
def BI(): return sys.stdin.buffer.readline().rstrip()
def SI(): return sys.stdin.buffer.readline().rstrip().decode()
# dij = [(0, 1), (-1, 0), (0, -1), (1, 0)]
dij = [(0, 1), (-1, 0), (0, -1), (1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]
inf = 10**16
# md = 998244353
md = 10**9+7

for _ in range(II()):
    n = II()
    rr = LI()
    cc = LI()
    rc = [(r, c) for r, c in zip(rr, cc)]
    rc.sort()
    ans = 0
    now = 0
    pr = 1
    for r, c in rc:
        nxt = r-c
        if now < nxt:
            if now & 1:
                ans += (nxt-now+1)//2
            else:
                ans += (nxt-now)//2
        elif now > nxt:
            if now & 1:
                ans += (nxt-now)//2
            else:
                ans += (nxt-now+1)//2
        elif now & 1 == 0:
            ans += r-pr
        now = nxt
        pr = r

    print(ans)
