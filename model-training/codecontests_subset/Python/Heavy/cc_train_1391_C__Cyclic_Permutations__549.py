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
    return sys.stdin.readline().rstrip()


def mpint():
    return map(int, inp().split(' '))


def itg():
    return int(inp())


# ############################## import
# from ACgenerator.Y_Testing import get_code
MOD = int(1e9) + 7
MAXSIZE = int(1e6) + 3
STACK = {}


def cache(func):
    STACK[func.__name__] = []

    def new_func(n):
        stack = STACK[func.__name__]
        while n >= len(stack):
            stack.append(func(len(stack)))
        return stack[n]

    return new_func


@cache
def A000142(n):
    """
    Factorial numbers: n! = 1*2*3*4*...*n
    1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800,

    O(n): a(n)
    O(n): a(0)~a(n)

    Cited by:
    A059204 (number of permutations of n letters)
    """
    return 1 if n <= 1 else (A000142(n - 1) * n) % MOD


@cache
def A011782(n):
    """
    2^n
    1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536,

    O(logn): a(n) ( using builtin pow )
    O(n): a(0)~a(n)

    Cited by:
    A059204:
    number of unimodal permutations e.g. 12345 or 54321 or 12543
    permutations like 213 or 312 are not
    and there are 2^(n-1) that is unimodal which n is the number of items
    """
    return 1 if n <= 0 else (A011782(n - 1) << 1) % MOD


def A059204(n):
    """
    Number of non-unimodal permutations of n items
    (i.e., those which do not simply go up for the first part
    and then down for the rest, but at some point go down then up).
    e.g. 213 or 312 is non-unimodal
    and 12345 or 54321 or 12543 is unimodal

    0, 0, 0, 2, 16, 104, 688, 4976, 40192, 362624, 3628288, 39915776, 478999552, 6227016704

    O(n): a(n)
    O(n): a(0)~a(n)
    """
    return (A000142(n) - A011782(n - 1)) % MOD


# ############################## main
def solve():
    return A059204(itg())


def main():
    # print("YES" if solve() else "NO")
    # print("yes" if solve() else "no")
    # solve()
    print(solve())
    # for _ in range(itg()):
    #     print(solve())


DEBUG = 0
URL = 'https://codeforces.com/contest/1391/problem/C'

if __name__ == '__main__':
    if DEBUG == 1:
        import requests  # ImportError: cannot import name 'md5' from 'sys' (unknown location)
        from ACgenerator.Y_Test_Case_Runner import TestCaseRunner

        runner = TestCaseRunner(main, URL)
        inp = runner.input_stream
        print = runner.output_stream
        runner.checking()
    elif DEBUG == 2:
        main()
    else:
        sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
        main()
# Please check!
