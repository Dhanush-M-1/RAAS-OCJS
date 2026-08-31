import math


def get_primes(prime_supr):

    is_prime = [0]*2 + [1]*prime_supr

    for i in range(2,int(math.sqrt(prime_supr)) + 1):
        if is_prime[i]:
            for j in range(i * i, prime_supr + 1, i):
                is_prime[j] = 0

    return is_prime

get_int = lambda: map(int, input().split())

n, m = get_int()

x = [0 for i in range(m + 1)]

for i in range(n):
    z = list(get_int())
    for j in range(1, z[0]+1):
        x[z[j]] = 1

for i in range(1, m + 1):
    if x[i] == 0:
        print("NO")
        break
else:
    print("YES")

