import math


n, k = map(int, input().split())
numbers = list(map(int, input().split()))
divisors = {}
for v in numbers:
    cnt = 0
    if not v in divisors.keys():
        divisors[v] = []
    while v > 0:
        if not v in divisors.keys():
            divisors[v] = []
        divisors[v].append(cnt)
        v //= 2
        cnt += 1
    if not v in divisors.keys():
        divisors[v] = []
    divisors[v].append(cnt)
answer = 2 ** 64
for cnt in filter(None, divisors.values()):
    cnt.sort()
    if len(cnt) >= k and len(cnt) > 0:
        answer = min(answer, sum(cnt[:k]))
print(answer)
