from math import sqrt


def prime(n):
    if n in [2, 3]:
        return True
    if n < 2 or n % 2 == 0 or n % 3 == 0:
        return False
    i = 5
    while (i * i <= n):
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6
    return True


def factorize(n):  # o(sqr(n))
    c, ans = 2, []
    while (c * c < n):
        if n % c == 0:
            ans.extend([c, n // c])
        c += 1

    if c * c == n:
        ans.extend([c, c])
    return sorted(ans)


n = int(input())
if prime(n) or n == 1:
    print(1, 0, sep='\n')
else:
    fac, primes = factorize(n), []

    for i in fac:
        if prime(i):
            primes.append(i)
            if i * i in fac:
                print(1)
                exit(print(i * i))

        if len(primes) == 2 and len(fac) != len(primes):
            print(1)
            exit(print(primes[0] * primes[1]))
    print(2)
