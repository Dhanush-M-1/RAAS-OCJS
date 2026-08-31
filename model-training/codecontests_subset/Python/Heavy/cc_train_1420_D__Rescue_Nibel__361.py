import sys
from array import array  # noqa: F401
import typing as Tp  # noqa: F401


def input():
    return sys.stdin.buffer.readline().decode('utf-8')


def output(*args):
    sys.stdout.buffer.write(
        ('\n'.join(map(str, args)) + '\n').encode('utf-8')
    )


def main():
    from heapq import heappop, heappush
    n, k = map(int, input().split())
    mod = 998_244_353

    max_n = n + 100
    fac, inv = array('i', [1]) * max_n, array('i', [1]) * max_n
    for i in range(2, max_n):
        fac[i] = fac[i - 1] * i % mod
    inv[-1] = pow(fac[-1], mod - 2, mod)
    for i in range(max_n - 1, 0, -1):
        inv[i - 1] = inv[i] * i % mod

    ans = array('i', [0])
    a = sorted(tuple(map(int, input().split())) for _ in range(n))
    hq = []

    if k == 1:
        print(n)
        exit()

    for l, r in a:
        while hq and hq[0] < l:
            heappop(hq)
        if len(hq) >= k - 1:
            ans[0] += fac[len(hq)] * inv[k - 1] * inv[len(hq) - (k - 1)] % mod
            if ans[0] >= mod:
                ans[0] -= mod

        heappush(hq, r)

    print(ans[0])


if __name__ == '__main__':
    main()
