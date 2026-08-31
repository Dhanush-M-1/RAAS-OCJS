import math


def factorize(x):
    factors = []
    y = 1
    for i in range(2, int(math.sqrt(x) + 1)):
        while x % i == 0:
            factors.append(i)
            x //= i
            if i not in [2, 3, 5]:
                y *= i

    if x != 1:
        factors.append(x)
        if x not in [2, 3, 5]:
            y *= x

    return factors, y


a, b = map(int, input().split())

factorsa, x = factorize(a)
factorsb, y = factorize(b)

if x != y:
    print(-1)
else:
    print(abs(factorsa.count(2) - factorsb.count(2))
          + abs(factorsa.count(3) - factorsb.count(3))
          + abs(factorsa.count(5) - factorsb.count(5)))
