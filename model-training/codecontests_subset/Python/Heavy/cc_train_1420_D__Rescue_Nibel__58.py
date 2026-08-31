import traceback
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

sys.stdin = IOWrapper(sys.stdin)
# sys.stdout = IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")

#####################################################################

import math
from collections import defaultdict as dfd, Counter, deque
from functools import lru_cache
from itertools import accumulate

def geti():
    return int(input())

def gets():
    return input()

def getil():
    return list(map(int, input().split()))

def getsl():
    return input().split()

def getinps(s):
    inps = s.split()
    m = {'i': geti, 's': gets, 'il': getil, 'sl': getsl}
    if len(inps) == 1: return m[s]()
    return [m[k]() for k in inps]

def get2d(nrows, ncols, n=0):
    return [[n] * ncols for r in range(nrows)]

def get_acc(a):
    return list(accumulate(a))

def get_ncr(n, r, mod=10**9+7):
    num = den = 1
    r = min(r, n-r)
    for i in range(r):
        num = (num * (n - i)) % mod
        den = (den * (i + 1)) % mod
    return num * pow(den, mod - 2, mod) % mod

def get_nc2(n):
    return n * (n-1) // 2
    
def get_npr(n, r):
    if n < r: return 0
    return math.factorial(n) // math.factorial(r) 

def put(a):
    return ' '.join(map(str, a))

# sys.stdin = open('input.txt', 'r')
# sys.stdout = open('output.txt', 'w')

# while y:
#     x, y = y, x % y

inf = float('inf')
mod = 10 ** 9 + 7



def make_ncr_mod(max_n=2 * 10**5, mod=10**9 + 7):
    max_n = min(max_n, mod - 1)

    fact, inv_fact = [0] * (max_n + 1), [0] * (max_n + 1)
    fact[0] = 1
    for i in range(max_n):
        fact[i + 1] = fact[i] * (i + 1) % mod

    inv_fact[-1] = pow(fact[-1], mod - 2, mod)
    for i in reversed(range(max_n)):
        inv_fact[i] = inv_fact[i + 1] * (i + 1) % mod

    def nCr_mod(n, r):
        res = 1
        while n or r:
            a, b = n % mod, r % mod
            if a < b:
                return 0
            res = res * fact[a] % mod * inv_fact[b] % mod * inv_fact[a - b] % mod
            n //= mod
            r //= mod
        return res

    return nCr_mod


def main():
    N, k = getil()
    a = []
    b = []
    for _ in range(N):
        x, y = (getil())
        a.append(x)
        b.append(y)
    mod = 998244353
    ncr = make_ncr_mod(max_n=3*10**5, mod=mod)
    ans = 0
    a.sort()
    b.sort()
    i = j = 0
    cnt = 0
    # print(a)
    # print(b)
    N = len(a)
    while i < N:
        if a[i] <= b[j]:
            cnt += 1
            i += 1
            # print(cnt,i,j)
            ans += ncr(cnt-1, k-1)
            ans %= mod
        else:
            cnt -= 1
            j += 1
    return ans



try:
    ans = main()
    ans = str(ans)
    print(ans)

except Exception as e:
    print(e)
    traceback.print_exc()

