import io
import os

from collections import Counter, defaultdict, deque


def primeFactors(n):
    # Returns a Counter of prime factors of n
    # e.g., 12 returns {2: 2, 3: 1}
    assert n >= 1
    factors = Counter()
    while n % 2 == 0:
        factors[2] += 1
        n //= 2
    x = 3
    while x * x <= n:
        while n % x == 0:
            factors[x] += 1
            n //= x
        x += 2
    if n != 1:
        factors[n] += 1
    return factors


def solve(X,):
    factors = sorted([k ** v for k, v in primeFactors(X).items()])
    best = (X, 1)
    for mask in range(1 << len(factors)):
        check1 = 1
        check2 = 1
        for i in range(len(factors)):
            if mask & (1 << i):
                check1 *= factors[i]
            else:
                check2 *= factors[i]

        assert check1 * check2 == X
        if check1 >= check2:
            best = min(best, (check1, check2))
        else:
            best = min(best, (check2, check1))

    return str(best[0]) + " " + str(best[1])


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    (X,) = [int(x) for x in input().split()]
    ans = solve(X,)
    print(ans)
