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
def to_list(binary_num, size=None):
    """
    to_list(11, 5) -> [0, 1, 0, 1, 1]
    """
    if size is None:
        size = binary_num.bit_length()
    result = [0] * size
    index = size - 1
    while binary_num:
        if binary_num & 1:
            result[index] = 1
        index -= 1
        binary_num >>= 1
    return result


# ############################## main
def invert(x):
    return '0' if x == '1' else '1'


def solve():
    n = itg()
    g = [inp() for _ in range(n)]
    arr = (g[0][1], g[1][0], g[n - 2][-1], g[-1][n - 2])
    pos = [(1, 2), (2, 1), (n - 1, n), (n, n - 1)]
    for bit in range(2 ** 4):
        bit = to_list(bit, 4)
        if sum(bit) > 2:
            continue
        tmp = list(arr)
        for i, b in enumerate(bit):
            if b:
                tmp[i] = invert(tmp[i])
        a, b, c, d = tmp
        if a == b and c == d and a != c:
            print(sum(bit))
            for i, b in enumerate(bit):
                if b:
                    print(*pos[i])
            return
    while True:
        pass


def main():
    # print("YES" if solve() else "NO")
    # print("yes" if solve() else "no")
    # solve()
    # print(solve())
    for _ in range(itg()):
        # print(solve())
        solve()


DEBUG = 0
URL = 'https://codeforces.com/contest/1421/problem/0'

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
