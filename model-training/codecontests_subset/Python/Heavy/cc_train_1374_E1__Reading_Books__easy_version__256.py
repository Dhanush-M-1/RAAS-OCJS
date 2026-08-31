from sys import stdin, stdout
import math
from collections import defaultdict, deque

n, k = map(int, stdin.readline().split())
al, bl, both = [], [], []
for _ in range(n):
    t, a, b = map(int, stdin.readline().split())
    if a == 0 and b == 0:
        continue
    if a == 1 and b == 1:
        both.append(t)
    elif a == 1:
        al.append(t)
    elif b == 1:
        bl.append(t)

al, bl, both = deque(sorted(al)[:k]), deque(sorted(bl)[:k]), deque(sorted(both)[:k])
res, cnt = 0, 0

while cnt < k:
    if both:
        if al and bl:
            if both[0] < al[0]+bl[0]:
                res += both[0]
                both.popleft()
                cnt += 1
            else:
                res += al[0]+bl[0]
                al.popleft()
                bl.popleft()
                cnt += 1
        else:
            res += both[0]
            both.popleft()
            cnt += 1
    else:
        if al and bl:
            res += al[0]+bl[0]
            al.popleft()
            bl.popleft()
            cnt += 1
        else:
            res = -1
            break
print(res)
