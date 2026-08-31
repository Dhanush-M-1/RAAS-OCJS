import sys
from bisect import bisect_left

sys.setrecursionlimit(10 ** 7)
input = sys.stdin.readline
f_inf = float('inf')
mod = 10 ** 9 + 7


def solve():
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    X = list(map(int, input().split()))

    pref = []
    ind = []
    step = 0
    for i, a in enumerate(A):
        step += a
        if not pref or step > pref[-1]:
            pref.append(step)
            ind.append(i)

    res = [0] * m
    for j, x in enumerate(X):
        if pref[-1] < x and step <= 0:
            res[j] = -1
        else:
            loop = 0
            if pref[-1] < x:
                loop = (x - pref[-1] + step - 1) // step
            x -= loop * step
            idx = bisect_left(pref, x)
            res[j] = loop * n + ind[idx]
    print(*res)


def resolve():
    t = int(input())
    for t in range(t):
        solve()


if __name__ == '__main__':
    resolve()
