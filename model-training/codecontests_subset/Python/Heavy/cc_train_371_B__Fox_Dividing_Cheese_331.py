import math
a, b = map(int, input().split())


def get_factors(a):
    fac = {}
    for i in range(2, int(math.sqrt(a) + 1)):
        while a % i == 0:
            fac[i] = fac.get(i, 0) + 1
            a = a // i
    if a != 1:
        fac[a] = fac.get(a, 0) + 1
    return fac


def get_intersection(fa, fb):
    res = {}
    for k in set(fa.keys()).intersection(set(fb.keys())):
        res[k] = min(fa[k], fb[k])

    return res


def get_symmetric_diff(factors, intersection):
    symmetric_diff = {}
    for k, v in factors.items():
        c = v - intersection.get(k, 0)
        if c != 0:
            symmetric_diff[k] = v - intersection.get(k, 0)
    return symmetric_diff


factors_a = get_factors(a)
factors_b = get_factors(b)
ab = get_intersection(factors_a, factors_b)

a_minus_b = get_symmetric_diff(factors_a, ab)
b_minus_a = get_symmetric_diff(factors_b, ab)

if not all([i in [2, 3, 5] for i in list(a_minus_b.keys()) + list(b_minus_a.keys())]):
    print(-1)
    exit()

print(sum(a_minus_b.values()) + sum(b_minus_a.values()))