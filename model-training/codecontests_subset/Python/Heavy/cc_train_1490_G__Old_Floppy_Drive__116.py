import sys
import math
import heapq
import bisect
from collections import Counter
from collections import defaultdict
from io import BytesIO, IOBase
import string


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        import os
        self.os = os
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None
        self.BUFSIZE = 8192

    def read(self):
        while True:
            b = self.os.read(self._fd, max(self.os.fstat(self._fd).st_size, self.BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()

    def readline(self):
        while self.newlines == 0:
            b = self.os.read(self._fd, max(self.os.fstat(self._fd).st_size, self.BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()

    def flush(self):
        if self.writable:
            self.os.write(self._fd, self.buffer.getvalue())
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


def get_int():
    return int(input())


def get_ints():
    return list(map(int, input().split(' ')))


def get_int_grid(n):
    return [get_ints() for _ in range(n)]


def get_str():
    return input().split(' ')


def yes_no(b):
    if b:
        return "YES"
    else:
        return "NO"


def binary_search(good, left, right, delta=1, right_true=False):
    """
    Performs binary search
    ----------
    Parameters
    ----------
    :param good: Function used to perform the binary search
    :param left: Starting value of left limit
    :param right: Starting value of the right limit
    :param delta: Margin of error, defaults value of 1 for integer binary search
    :param right_true: Boolean, for whether the right limit is the true invariant
    :return: Returns the most extremal value interval [left, right] which is good function evaluates to True,
            alternatively returns False if no such value found
    """

    limits = [left, right]
    while limits[1] - limits[0] > delta:
        if delta == 1:
            mid = sum(limits) // 2
        else:
            mid = sum(limits) / 2
        if good(mid):
            limits[int(right_true)] = mid
        else:
            limits[int(~right_true)] = mid
    if good(limits[int(right_true)]):
        return limits[int(right_true)]
    else:
        return False


def prefix_sums(a):
    p = [0]
    for x in a:
        p.append(p[-1] + x)
    return p


def prefix_max(a):
    p = [-float('inf')]
    for x in a:
        p.append(max(p[-1], x))
    return p


def ceil_div(a, b):
    return a // b + int(a % b != 0)


def solve_a():
    n = get_int()
    a = get_ints()
    k = 0
    for i in range(n - 1):
        A = max(a[i], a[i + 1])
        B = min(a[i], a[i + 1])
        while 2 * B < A:
            k += 1
            B *= 2
    return k


def solve_b():
    n = get_int()
    a = get_ints()
    rems = [x % 3 for x in a]
    count_rems = [rems.count(i) for i in range(3)]
    k = 0
    for repeat in range(2):
        for i in range(3):
            if count_rems[i] > n // 3:
                k += count_rems[i] - n // 3
                count_rems[(i + 1) % 3] += count_rems[i] - n // 3
                count_rems[i] = n // 3
    return k


def solve_c():

    cubes = set()
    i = 1
    while i ** 3 < 10 ** 12 + 1:
        cubes.add(i ** 3)
        i += 1

    def solve():
        x = get_int()
        j = 1
        while j ** 3 <= x:
            if x - j ** 3 in cubes:
                return "YES"
            j += 1
        return "NO"

    t = get_int()
    for _ in range(t):
        print(solve())


def solve_d():
    n = get_int()
    p = get_ints()
    dp = [-1] * n
    for i in range(n, 0, -1):
        X = p.index(i)
        m = -1
        for j in range(X, n):
            if dp[j] > - 1:
                m = max(m, dp[j])
                break
        for j in range(X, -1, -1):
            if dp[j] > - 1:
                m = max(m, dp[j])
                break
        dp[X] = m + 1

    res = {}

    return dp


def solve_e():
    n = get_int()
    a = get_ints()

    a_uniq = list(set(a))
    a_uniq.sort()

    a_count = Counter(a)

    def good(k):
        x = a_uniq[k]
        #Can the number of tokens at kth position win
        for i in range(len(a_uniq)):
            if x >= a_uniq[i]:
                x += a_uniq[i] * (a_count[a_uniq[i]] - int(i == k))
            else:
                return False
        return True

    L = -1
    R = len(a_uniq) - 1

    bs = binary_search(good, L, R, right_true=True)

    u = a_uniq[bs]

    res = []

    for i in range(n):
        if a[i] >= u:
            res.append(i + 1)

    return res


def solve_f():
    n = get_int()
    a = get_ints()

    C = Counter(a)

    candidates = set(C.values())

    S = float('inf')

    for cand in candidates:
        tmp = 0
        for k in C:
            if C[k] < cand:
                tmp += C[k]
            elif C[k] > cand:
                tmp += C[k] - cand
        S = min(S, tmp)

    return S


def solve_g():
    n, m = get_ints()
    a = get_ints()
    x = get_ints()

    S = sum(a)

    p = prefix_sums(a)
    pm = prefix_max(p)[2:]

    def respond(y):

        if S <= 0 and pm[-1] < y:
            return - 1
        if S > 0:
            rots = max(0, ceil_div(y - pm[-1], S))
        else:
            rots = 0
        y -= rots * S
        if y == 0:
            z = -1
        else:
            z = bisect.bisect_left(pm, y)
        return rots * n + z

    response = [respond(y) for y in x]
    return response


t = get_int()
for _ in range(t):
    print(*solve_g())
