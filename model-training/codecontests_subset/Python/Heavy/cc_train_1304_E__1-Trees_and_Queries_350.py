import os
import sys
from io import BytesIO, IOBase
# region fastio

BUFSIZE = 8192

class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None

    def read(self):
        while True:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()

    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()

    def flush(self):
        if self.writable:
            os.write(self._fd, self.buffer.getvalue())
            self.buffer.truncate(0), self.buffer.seek(0)


class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")

# ------------------------------

from math import factorial, log2, floor
from collections import Counter, defaultdict, deque
from heapq import heapify, heappop, heappush

def RL(): return map(int, sys.stdin.readline().rstrip().split())
def RLL(): return list(map(int, sys.stdin.readline().rstrip().split()))
def N(): return int(input())
def comb(n, m): return factorial(n) / (factorial(m) * factorial(n - m)) if n >= m else 0
def perm(n, m): return factorial(n) // (factorial(n - m)) if n >= m else 0
def mdis(x1, y1, x2, y2): return abs(x1 - x2) + abs(y1 - y2)
mod = 998244353
INF = float('inf')

# ------------------------------

def main():
    n = N()
    gp = [[] for _ in range(n+1)]

    for _ in range(n-1):
        f, t = RL()
        gp[f].append(t)
        gp[t].append(f)

    mxd = floor(log2(n))

    marr = [[0]*(mxd+1) for _ in range(n+1)]
    par = [1]*(n+1)
    deep = [0]*(n+1)

    vis = [0]*(n+1)
    q = deque()
    q.append((1, 0))
    vis[1] = 1
    while q:
        nd, d = q.popleft()
        deep[nd] = d

        marr[nd][0] = par[nd]

        for i in range(1, mxd+1):
            if 2**i>d: break
            marr[nd][i] = marr[marr[nd][i-1]][i-1]

        for nex in gp[nd]:
            if vis[nex]==1: continue
            vis[nex] = 1
            par[nex] = nd
            q.append((nex, d+1))

    # for i in marr:
    #     print(i)

    def lca(a, b):
        ta, tb = a, b
        if deep[a]>deep[b]:
            a, b = b, a

        for i in range(mxd, -1, -1):
            if marr[b][i]!=-1 and deep[marr[b][i]]>=deep[a]:
                b = marr[b][i]

        if a==b: return deep[ta]-deep[a]+deep[tb]-deep[a]

        for i in range(mxd, -1, -1):
            if marr[b][i] != marr[a][i]:
                a = marr[a][i]
                b = marr[b][i]

        ld = par[a] if a!=b else a

        return deep[ta]-deep[ld]+deep[tb]-deep[ld]


    qn = N()
    for _ in range(qn):
        x, y, a, b, k = RL()
        lst = k & 1

        dis = lca(a, b)
        disaxyb = (lca(a, x) + lca(y, b) + 1)
        disayxb = (lca(a, y) + lca(x, b) + 1)


        if (dis<=k and dis&1==lst) or (disaxyb<=k and disaxyb&1==lst) or (disayxb<=k and disayxb&1==lst):
            print("YES")
        else:
            print("NO")

if __name__ == "__main__":
    main()

