from math import ceil

hy, ay, dy = map(int, input().split())
hm, am, dm = map(int, input().split())
hp, ap, dp = map(int, input().split())


def time(ay, hm, dm):
    return float('inf') if ay <= dm else ceil(hm / (ay - dm))


def health_need(t, dy, am):
    return 0 if dy >= am else t * (am - dy) + 1


min_p = float('inf')
for a in range(ay, 200 + 1):
    t = time(a, hm, dm)
    if t == float('inf'):
        continue

    for d in range(dy, 100 + 1):
        h = health_need(t, d, am)

        a_p = (a - ay) * ap
        d_p = (d - dy) * dp
        h_p = max(0, h - hy) * hp

        total = a_p + d_p + h_p
        if total < min_p:
            min_p = total

print(min_p)