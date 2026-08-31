import itertools

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

n = int(input())

fs = []
last_f = 1
for f in prime_factors(n):
    if f == last_f:
        fs[-1] *= f
    else:
        fs.append(f)
        last_f = f

def findsubsets(S,m):
    return set(itertools.combinations(S, m))

def allsubsets(S):
    out = set([])
    for i in range(1, len(S)+1):
        out = out | findsubsets(S, i)
    return out

alls = allsubsets(fs)

sol = [1, 1]
sol_m = 10**13
for ss in alls:
    p1 = 1
    for si in ss:
        p1 *= si
    p2 = n // p1
    if max(p1, p2) < sol_m:
        sol = [p1, p2]
        sol_m = max(p1, p2)

print(sol[0], sol[1])