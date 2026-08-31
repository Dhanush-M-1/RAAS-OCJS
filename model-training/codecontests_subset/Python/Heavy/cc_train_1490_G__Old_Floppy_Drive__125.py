import collections
import string
import math
import copy
import os
import sys
from io import BytesIO, IOBase

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


def input(): return sys.stdin.readline().rstrip("\r\n")


# n = 0
# m = 0

# n = int(input())

# li = [int(i) for i in input().split()]

# s = sorted(li)

mo = 998244353


def exgcd(a, b):
    if not b:
        return 1, 0
    y, x = exgcd(b, a % b)
    y -= a//b * x
    return x, y


def getinv(a, m):
    x, y = exgcd(a, m)
    return -(-1) if x == 1 else x % m


def comb(n, b):
    res = 1
    b = min(b, n-b)
    for i in range(b):
        res = res*(n-i)*getinv(i+1, mo) % mo
        # res %= mo
    return res % mo


def quickpower(a, n):
    res = 1
    while n:
        if n & 1:
            res = res * a % mo
        n >>= 1
        a = a*a % mo
    return res


def dis(a, b):
    return abs(a[0]-b[0]) + abs(a[1]-b[1])


def getpref(x):
    if x > 1:
        return (x)*(x-1) >> 1
    else:
        return 0


def orafli(upp):
    primes = []
    marked = [False for i in range(upp+3)]
    for i in range(2, upp):
        if not marked[i]:
            primes.append(i)
        for j in primes:
            if i*j >= upp:
                break
            marked[i*j] = True
            if i % j == 0:
                break
    return primes
# history = {}
# askctr = 0
# def ask(s):
#     global askctr, history
#     if s in history:
#         return history[s]
#     askctr+=1
#     print(f"? {s}", flush=True)
#     ret = int(input())
#     hisadd(s, ret)
#     chkans(s)
#     return ret

# def answer(s):
#     print(f"! {s}", flush=True)
#     # return int(input())


# def getans(history, l, r):
#     for i in range(l, r+1):
#         ask(i)
#         history[i] = int(input())
#         if i==2:
#             if 1 in history:
#                 if history[2]>history[1]:
#                     answer(1)
#                     return
#         else:
#             if i-1 in history and i-2 in history:
#                 if history[i-1]<history[i-2] and history[i-1]<history[i]:
#                     answer(i-1)
#                     return

# def chkans(i):
#     global history, n
#     if i==1:
#         if history.get(2,0)>history.get(1,999999999):
#             answer(1)
#             exit(0)
#             return True
#     elif i==n:
#         if history.get(n-1,0)>history.get(n,999999999):
#             answer(n)
#             exit(0)
#             return True
#     elif history.get(i-1, 0) > history.get(i, 99999999) < history.get(i+1, 0):
#         if 0<i<=n:
#             answer(i)
#             exit(0)
#             return True
#     return False


# def hisadd(pos, val):
#     global history
#     if val == 1:
#         answer(pos)
#         exit(0)
#         return True
#     else:
#         history[pos] = val
#         return chkans(pos)



def solve():
    n,m = map(int, input().split())

    a = [int(i) for p,i in enumerate(input().split())]
    mx = -1145141919810931
    su = 0
    ans = [0 for i in range(m)]
    for i in a:
        su+=i
        mx = max(mx,su)
    # mx = max(a)
    s = sum(a)
    x = [[int(i), p] for p,i in enumerate(input().split())]
    if s>0:
        for p,pp in enumerate(x):
            i,j=pp
            if i>mx:
                lop = math.ceil((i - mx)/s)
                ans[j]+=lop*n
                x[p][0] -= math.ceil((i - mx)/s)*s
    x.sort(reverse=True)
    
    su = 0
    sec = 0
    # his = {}
    for i in a:
        su += i
        if not x:
            break
        else:
            while x:
                if x[-1][0]<=su:
                    ans[x[-1][1]] += sec
                    x.pop()
                else:
                    break
        # his[su] = sec
        sec+=1
    if s<=0:
        while x:
            t, pos = x.pop()
            ans[pos] = -1
    print(*ans)
    # else:
    #     for i in range(len(x)):
    #         subb = math.ceil((x[i][0] - mx)/k)
    #         x[i][0] -= 
    #     while x:

    #         t, pos = x.pop()


   
t = int(input())



for ti in range(t):
    solve()
    
    