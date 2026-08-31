import math

def divisors(n):
    divs = []
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            divs.extend([i, n // i])
    return set(divs)


def factorize(divs, n):
    v = n
    divs = list(sorted(divs))
    idx = 0
    ans = []
    while v > 1:
        if v % divs[idx] == 0:
            ans.append(divs[idx])
            v //= divs[idx]
        else:
            idx += 1
    return ans


n = int(input())

divs = divisors(n)

if len(divs) == 0:
    print(1)
    print(0)
else:
    factors = factorize(divs, n)
    if len(factors) == 2:
        print(2)
    else:
        print(1)
        print(factors[0] * factors[1])