from bisect import *
from random import *
from itertools import *
import sys
read = sys.stdin.readline
write = lambda x, end="\n": sys.stdout.write(x + end)


def naive(a, q, t, m):
    if t <= 0 and m < q:
        return -1
    x = 0
    for i in count():
        x += a[i % len(a)]
        if x >= q:
            return i


def g(a, q, t, m):
    return bisect_left(d, q)


def f(a, q, t, m):
    if t <= 0 and m < q:
        return -1
    elif q <= m:
        return g(a, q, t, m)
    z = 0 if t == 0 else max(0, (q - m) // t)
    return z * len(a) + g(a, q - t * z, t, m)


# for _ in range(1000):
#     n = m = 10
#     a = [randint(-100, 100) for _ in range(10)]
#     c = list(accumulate(a))
#     d = list(accumulate(list(accumulate(a + a)), max))
#     m = max(c)
#     t = sum(a)
#     for _ in range(100):
#         q = randint(1, 10**4)
#         x = f(a, q, t, m)
#         y = naive(a, q, t, m)
#         assert x == y, (x, y, a, q)


for _ in range(int(read())):
    n, m = map(int, read().split())
    a = list(map(int, read().split()))
    c = list(accumulate(a))
    d = list(accumulate(list(accumulate(a + a)), max))
    # print(d)
    m = max(c)
    t = sum(a)
    res = []
    z = []
    for q in map(int, read().split()):
        z.append(f(a, q, t, m))
        #res.append(naive(a, q, t, m))
    print(*z)
    # print(*res)
    # print()
