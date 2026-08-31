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
    i, j = 0, n - 1
    ans = 'Yes'
    cur = 0
    while i <= j:
        if a[i] >= cur and a[j] >= cur:
            cur += 1
            i += 1
            j -= 1
        else:
            ans = 'No'
            break
    if n % 2 == 0 and a[j] == a[i] == cur - 1:
        ans = 'No'
    print(ans)