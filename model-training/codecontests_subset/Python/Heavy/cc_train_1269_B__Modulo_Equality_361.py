def inp():
    return map(int, stdin.readline().split())


def arr_inp():
    return [int(x) for x in stdin.readline().split()]


from sys import *
from collections import *
from math import *

n, m = inp()
a, b = [arr_inp() for i in range(2)]
a1, b1 = Counter(a), Counter(b)
a, b, ans = deque(sorted(set(a))), deque(sorted(set(b))), inf

for i in range(len(b)):
    flag, diff = 1, (b[0] - a[0]) % m

    for j in range(len(b)):
        if a1[a[j]] == b1[b[j]] and (b[j] - a[j]) % m == diff:
            continue
        if a1[a[j]] != b1[b[j]] or (b[j] - a[j]) % m != diff:
            flag = 0
            break
    if flag:
        ans = min(ans, diff)
    a.rotate(- 1)
print(ans)
