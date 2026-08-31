import os
import sys
from io import BytesIO, IOBase


def solution(trees, heights, n):
    if n == 1:
        write(1)
        return

    dp = [[0] * 3 for _ in range(n)]
    trees.append(float("inf"))

    # dp states
    # 1 to i - 1 :-
    # 0 : i stands
    # 1 : i falls to left
    # 2 : i falls to right

    dp[0][0] = 0
    dp[0][1] = 1
    dp[0][2] = 1 if trees[0] + heights[0] < trees[1] else 0

    for i in range(1, n):
        # i stays
        if trees[i - 1] + heights[i - 1] >= trees[i]:
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
        else:
            dp[i][0] = max([dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]])

        # i falls to left
        if trees[i] - heights[i] > trees[i - 1]:
            dp[i][1] = max(dp[i - 1][0], dp[i - 1][1]) + 1

            if trees[i - 1] + heights[i - 1] < trees[i] - heights[i]:
                dp[i][1] = max(dp[i][1], dp[i - 1][2] + 1)

        # i falls to right
        if trees[i] + heights[i] < trees[i + 1]:
            dp[i][2] = max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]) + 1

    write(max(dp[-1]))


def main():
    n = r_int()
    N = int(1e5 + 1)
    trees, heights = [], []
    for _ in range(n):
        x, h = r_array()
        trees.append(x)
        heights.append(h)

    solution(trees, heights, n)


# fast-io region

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


def input():
    return sys.stdin.readline().rstrip("\r\n")


def write(*args, end="\n"):
    for x in args[:-1]:
        sys.stdout.write(str(x) + " ")
    sys.stdout.write(str(args[-1]))
    sys.stdout.write(end)


def r_array():
    return [int(x) for x in input().split()]


def r_int():
    return int(input())


if __name__ == "__main__":
    main()
