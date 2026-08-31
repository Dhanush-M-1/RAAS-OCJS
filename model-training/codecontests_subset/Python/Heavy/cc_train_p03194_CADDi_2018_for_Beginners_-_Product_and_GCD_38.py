from collections import Counter

def prime_factorize_fast(n, res=Counter()):
    while n % 2 == 0:
        res[2] += 1
        n //= 2
    while n % 3 == 0:
        res[3] += 1
        n //= 3
    d = 5
    step = 2
    while d <= int(n ** .5):
        while n % d == 0:
            res[d] += 1
            n //= d
        d += step
        step = 6 - step
    if n != 1:
        res[n] += 1
    return res

N, P = map(int, input().split())
cnt = prime_factorize_fast(P)
ans = 1
for f in cnt:
    if cnt[f] >= N:
        ans *= f ** (cnt[f] // N)
print(ans)