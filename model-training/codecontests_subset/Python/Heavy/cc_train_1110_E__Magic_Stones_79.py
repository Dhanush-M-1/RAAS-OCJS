#!/usr/bin/env python3
import sys
from atexit import register
from io import FileIO, StringIO

sys.stdin = StringIO(FileIO(0).read().decode())
input = lambda: sys.stdin.readline().rstrip('\r\n')

sys.stdout = StringIO()
register(lambda: FileIO(1, 'w').write(sys.stdout.getvalue().encode()))


def main():
    n = int(input())

    c = list(map(int, input().split()))
    t = list(map(int, input().split()))

    if (c[0] != t[0]) or (c[-1] != t[-1]):
        print('No')
        return

    diff_c, diff_t = [0] * n, [0] * n
    for i in range(n - 1):
        diff_c[i], diff_t[i] = c[i + 1] - c[i], t[i + 1] - t[i]

    diff_c.sort()
    diff_t.sort()

    if diff_c == diff_t:
        print('Yes')
    else:
        print('No')


if __name__ == '__main__':
    main()
