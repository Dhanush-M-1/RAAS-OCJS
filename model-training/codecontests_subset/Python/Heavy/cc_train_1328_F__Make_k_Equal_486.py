from sys import stdin
from sys import setrecursionlimit as SRL; SRL(10**7)
rd = stdin.readline
rrd = lambda: map(int, rd().strip().split())

n,k = rrd()

a = list(rrd())

cnt = [0]*400005
a.sort()

for i in a:
    cnt[i] += 1

for i in range(400002):
    if i:
        cnt[i] += cnt[i-1]

mx = a[-1]

import math
ans = math.inf
for i in range(1,mx+1):

    now = k
    tot = 0
    l = i
    r = i
    st = 0

    while now:

        if l > 200000:
            tot = math.inf
            break

        p = min(cnt[r] - cnt[l-1],now)
        now -= p
        tot += st*p
        r = r*2+1
        l = l*2

        st += 1

    ans = min(ans,tot)



print(ans)
