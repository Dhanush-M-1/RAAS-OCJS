n=int(input())
dp={}
dp[1]=0
dp[2]=0
dp[3]=2
mod=1000000007
fact={}
fact[1]=1
fact[2]=2
fact[3]=6
p=2


def largestPower(n, p):
    # Initialize result
    x = 0

    # Calculate x = n/p + n/(p^2) + n/(p^3) + ....
    while (n):
        n //= p
        x += n
    return x


# Utility function to do modular exponentiation.
# It returns (x^y) % p
def power(x, y, p):
    res = 1  # Initialize result
    x = x % p  # Update x if it is more than
    # or equal to p
    while (y > 0):

        # If y is odd, multiply x with result
        if (y & 1):
            res = (res * x) % p

            # y must be even now
        y = y >> 1  # y = y/2
        x = (x * x) % p

    return res


# Returns n! % p
def modFact(n, p):
    if (n >= p):
        return 0

    res = 1

    # Use Sieve of Eratosthenes to find
    # all primes smaller than n
    isPrime = [1] * (n + 1)
    i = 2
    while (i * i <= n):
        if (isPrime[i]):
            for j in range(2 * i, n, i):
                isPrime[j] = 0
        i += 1

    # Consider all primes found by Sieve
    for i in range(2, n):
        if (isPrime[i]):
            # Find the largest power of prime 'i'
            # that divides n
            k = largestPower(n, i)

            # Multiply result with (i^k) % p
            res = (res * power(i, k, p)) % p

    return res
for i in range(3,n+1):
    fact[i]=(fact[i-1]*i)%mod


print((fact[n]-power(2,n-1,mod))%mod)

