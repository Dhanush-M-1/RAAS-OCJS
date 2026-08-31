from collections import Counter

n, k = map(int, input().split())
xs = sorted(map(int, input().split()))

c = Counter(xs)
csuml = 0
lcnt = 0
csumr = sum(xs)
rcnt = len(xs)
ans = csumr

for x, cnt in sorted(c.items()):
    r = max(0, k - cnt)
    if not r:
        ans = 0
        break

    csumr -= x * cnt
    rcnt -= cnt

    ansl = lcnt * (x - 1) - csuml + min(lcnt, r)
    if lcnt < r:
        ansl += csumr - rcnt * (x + 1) + r - lcnt

    ansr = csumr - rcnt * (x + 1) + min(rcnt, r)
    if rcnt < r:
        ansr += lcnt * (x - 1) - csuml + r - rcnt

    ans = min(ans, ansl, ansr)
    csuml += x * cnt
    lcnt += cnt

print(ans)
