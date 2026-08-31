from __future__ import division, print_function

import sys
from atexit import register

if sys.version_info[0] < 3:
    from io import BytesIO as stream
else:
    from io import StringIO as stream


sys.stdin = stream(sys.stdin.read())
input = lambda: sys.stdin.readline().rstrip('\r\n')

sys.stdout = stream()
register(lambda: sys.__stdout__.write(sys.stdout.getvalue()))


def read_int():
    return int(input())


def read_ints():
    return list(map(int, input().split(' ')))


def solve():
    n, m = read_ints()
    a = set(read_ints())
    b = set(read_ints())
    c = a & b
    if len(c) == 0:
        print('NO')
    else:
        print('YES')
        print(1, c.pop())


if __name__ == '__main__':
    T = read_int()
    for _ in range(T):
        solve()
