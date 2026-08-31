import math


n, k = map(int, input().split())
numbers = list(map(int, input().split()))
divisors = set()
divisors.add(0)
numbers.sort(reverse=True)
for p in range(18):
    m = 2 ** p
    for v in numbers:
        while v > 0:
            divisors.add(v)
            v //= 2
answer = 2 ** 64
for d in divisors:
    cnt = []
    for v in numbers:
        cur = 0
        while v > 0 and v != d:
            v //= 2
            cur += 1
        if v == d:
            cnt.append(cur)
    cnt.sort()
    if len(cnt) >= k:
        answer = min(answer, sum(cnt[:k]))
print(answer)
