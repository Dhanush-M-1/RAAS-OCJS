import math
from functools import reduce


def lcm(a, b):
    g = math.gcd(a, b)
    return a // g * b // g * g


def solve(n):
    return max(find_from_n(n), find_from_n(n - 1))


def find_from_n(n):
    if n == 0:
        return 1
    a = [n]
    for i in range(n - 1, 0, -1):
        if len(a) >= 3:
            break
        if all(math.gcd(i, x) == 1 for x in a):
            a.append(i)
    if len(a) >= 3 and a[-1] == 1:
        a[-1] = a[1] - 1
    return reduce(lambda x, y: lcm(x, y), a, a[0])


# assert solve(924) == 783776526
#
# assert solve(7) == 210
# assert solve(1) == 1
# assert solve(5) == 60
# assert solve(6) == 60
# assert solve(33) == 32736
# assert solve(21) == 7980
# assert solve(2) == 2
# assert solve(41) == 63960
# assert solve(29) == 21924
# assert solve(117) == 1560780
# assert solve(149) == 3241644
# assert solve(733) == 392222436
# assert solve(925) == 788888100
# assert solve(509) == 131096004
# assert solve(829) == 567662724
# assert solve(117) == 1560780
# assert solve(605) == 220348260
n = int(input())
r = max(solve(n), solve(n - 1))
print(r)
