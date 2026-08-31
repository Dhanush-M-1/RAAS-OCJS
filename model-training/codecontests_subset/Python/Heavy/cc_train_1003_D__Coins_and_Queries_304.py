from collections import defaultdict
import sys
input = sys.stdin.readline

n, q = map(int, input().split())
a = list(map(int, input().split()))
cnt = defaultdict(lambda : 0)
for i in a:
    cnt[i] += 1
pow2 = [1]
for _ in range(35):
    pow2.append(2 * pow2[-1])
for _ in range(q):
    x = [0] * 35
    b = int(input())
    ans = 0
    f = 1
    for i in range(34, 0, -1):
        p2 = pow2[i - 1]
        if not x[i] and not b & p2:
            continue
        if b & p2:
            x[i] += 1
        ans += min(x[i], cnt[p2])
        if x[i] <= cnt[p2]:
            x[i] = 0
        else:
            c = x[i] - cnt[p2]
            x[i - 1] += 2 * c
    if x[0]:
        ans = -1
    print(ans)