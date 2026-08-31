from collections import Counter

def prime_decomposition(n):
    i = 2
    table = []
    while i * i <= n:
        while n % i == 0:
            n /= i
            table.append(i)
        i += 1
    if n > 1:
        table.append(int(n))
    return table

N, P = [int(a) for a in input().strip().split()]

facs = prime_decomposition(P)
facc = Counter(facs)

common = 1
for fac in facc.keys():
    count = facc[fac]
    while count >= N:
        common = common*fac
        count -= N

print(int(common))

