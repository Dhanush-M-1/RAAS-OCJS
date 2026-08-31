import os
import sys
from io import BytesIO, IOBase

_str = str
BUFSIZE = 8192


def str(x=b''):
    return x if type(x) is bytes else _str(x).encode()


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = 'x' in file.mode or 'r' not in file.mode
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
            self.newlines = b.count(b'\n') + (not b)
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
        self.write = lambda s: self.buffer.write(s.encode('ascii'))
        self.read = lambda: self.buffer.read().decode('ascii')
        self.readline = lambda: self.buffer.readline().decode('ascii')


def inp():
    return sys.stdin.readline()


def mpint():
    return map(int, sys.stdin.readline().split(' '))


def itg():
    return int(sys.stdin.readline())


# ############################## import
MOD = 998244353


def make_nCr_mod(max_n=2 * 10 ** 5, mod=10 ** 9 + 7):
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


nCr = make_nCr_mod(int(3e5), 998244353)


# ############################## main
def solve():
    n, k = mpint()
    intervals = []
    for _ in range(n):
        a, b = mpint()
        intervals.append((a, 1))
        intervals.append((b, -1))
    intervals.sort(key=lambda p: p[0] * (n + 87) - p[1])
    ans = count = 0
    for idx, v in intervals:
        count += v
        if v == 1:
            ans += nCr(count - 1, k - 1)
    print(ans % MOD)


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)

if __name__ == '__main__':
    solve()
    # for _ in range(itg()):
    #     print(solve())
# Please check!
