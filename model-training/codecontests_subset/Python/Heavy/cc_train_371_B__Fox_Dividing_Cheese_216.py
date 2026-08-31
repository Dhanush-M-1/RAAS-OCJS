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


a, b = map(int, input().split())
factor_a = prime_factors(a)
factor_b = prime_factors(b)



freq_factor_a, freq_factor_b = dict(), dict()
freq_factor_a[2] = freq_factor_a[3] = freq_factor_a[5] = 0
freq_factor_b[2] = freq_factor_b[3] = freq_factor_b[5] = 0
for e in factor_a:
    if e in freq_factor_a:
        freq_factor_a[e] += 1
    else:
        freq_factor_a[e] = 1

for e in factor_b:
    if e in freq_factor_b:
        freq_factor_b[e] += 1
    else:
        freq_factor_b[e] = 1

no_solution = False
res = 0
possible_factors = list(set(freq_factor_a.keys()) | set(freq_factor_b.keys()))
for possible_factor in possible_factors:
    if (possible_factor in freq_factor_a and possible_factor not in freq_factor_b) or (
            possible_factor in freq_factor_b and possible_factor not in freq_factor_a):
        no_solution = True
        break
    elif possible_factor in [2, 3, 5]:
        res += abs(freq_factor_a[possible_factor] - freq_factor_b[possible_factor])
    elif freq_factor_a[possible_factor] != freq_factor_b[possible_factor]:
        no_solution = True
        break

print(-1 if no_solution else res)
