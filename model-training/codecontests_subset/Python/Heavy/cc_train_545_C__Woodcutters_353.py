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

n, = I()
a = [[INF, INF]]
for i in range(n):
    x, h = I()
    a.append([x, h])
a.sort()
ans = 1
for i in range(1, n):
    if a[i][0] - a[i - 1][0] > a[i][1]:
        ans += 1
    elif a[i + 1][0] - a[i][0] > a[i][1]:
        ans += 1
        a[i][0] += a[i][1]
print(ans)