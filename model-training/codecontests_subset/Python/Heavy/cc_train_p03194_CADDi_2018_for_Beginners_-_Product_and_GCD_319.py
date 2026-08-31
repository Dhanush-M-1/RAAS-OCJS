# https://stackoverflow.com/questions/15347174/python-finding-prime-factors
def prime_factors(n):
    i = 2
    factors = []
    while i * i <= n:
        if n % i:
            i += 1
        else:
            n //= i
            factors.append(i)
    if n > 1:
        factors.append(n)
    return factors



N, P = [int(_) for _ in input().split()]


import collections
lst = prime_factors(P)
c = collections.Counter(lst)

result = 1
for k in c.keys():
    temp = c[k] // N
    if temp >= 1:
        result *= (k ** temp)

print(result)