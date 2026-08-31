import sys
def fastio():
    from io import StringIO
    from atexit import register
    global input
    sys.stdin = StringIO(sys.stdin.read())
    input = lambda : sys.stdin.readline().rstrip('\r\n')
    sys.stdout = StringIO()
    register(lambda : sys.__stdout__.write(sys.stdout.getvalue()))
fastio()

def debug(*var, sep = ' ', end = '\n'):
    print(*var, file=sys.stderr, end = end, sep = sep)

INF = 10**20
MOD = 10**9 + 7
I = lambda:list(map(int,input().split()))
from math import gcd
from math import ceil
from collections import defaultdict as dd, Counter
from bisect import bisect_left as bl, bisect_right as br

t, = I()
while t:
    t -= 1
    n, = I()
    a = I()
    b = set()
    init = 0
    for i in range(n):
        if i > 0 and a[i] >= 0 and a[i - 1] >= 0:
            init = max(init, abs(a[i] - a[i - 1]))
        if a[i] == -1:
            if i - 1 >= 0 and a[i - 1] >= 0:
                b.add(a[i - 1])
            if i + 1 < n and a[i + 1] >= 0:
                b.add(a[i + 1])
    b = list(b)
    if not b:
        print(0, 1)
    else:
        mx = max(b)
        mn = min(b)
        ans = (min(b) + max(b)) // 2
        print(max(init, ans - mn, mx - ans), ans)