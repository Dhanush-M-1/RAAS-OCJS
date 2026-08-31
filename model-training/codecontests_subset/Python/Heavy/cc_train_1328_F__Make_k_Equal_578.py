from sys import stdin
from collections import *


def arr_inp(n):
    if n == 1:
        return [int(x) for x in stdin.readline().split()]
    elif n == 2:
        return [float(x) for x in stdin.readline().split()]
    else:
        return [str(x) for x in stdin.readline().split()]


def divide(x):
    num = 0
    mem[x][0] += 1

    while (x):
        x //= 2
        num += 1

        if mem[x][0] < k:
            mem[x][0] += 1
            mem[x][1] += num


n, k = arr_inp(1)
a, mem = sorted(arr_inp(1)), defaultdict(lambda: [0, 0])
c, ans = Counter(a), float('inf')

for i in range(n):
    divide(a[i])

for i in range(max(a) + 1):
    if mem[i][0] >= k:
        ans = min(ans, mem[i][1])

print(ans)
