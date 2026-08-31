from sys import stdin, stdout
import heapq
import cProfile
from collections import Counter, defaultdict, deque
from functools import reduce
import math


def get_int():
    return int(stdin.readline().strip())


def get_tuple():
    return map(int, stdin.readline().split())


def get_list():
    return list(map(int, stdin.readline().split()))


def power(x, y, p):
    res = 1;  # Initialize result
    x = x % p;  # Update x if it is more
    # than or equal to p
    while (y > 0):

        # If y is odd, multiply
        # x with result
        if (y & 1):
            res = (res * x) % p;

            # y must be even now
        y = y >> 1;  # y = y/2
        x = (x * x) % p;

    return res


# Function to find modular inverse
# of a under modulo p using Fermat's
# method. Assumption: p is prime
def modInverse(a, p):
    return power(a, p - 2, p)


# Returns n! % p using
# Wilson's Theorem
def modFact(n, p):
    # n! % p is 0 if n >= p
    if (p <= n):
        return 0

    # Initialize result as (p-1)!
    # which is -1 or (p-1)
    res = (p - 1)

    # Multiply modulo inverse of
    # all numbers from (n+1) to p
    for i in range(n + 1, p):
        res = (res * modInverse(i, p)) % p
    return res


def is_prime(n):
    """Returns True if n is prime."""
    if n < 4:
        return True
    if n % 2 == 0:
        return False
    if n % 3 == 0:
        return False
    i = 5
    w = 2
    while i * i <= n:
        if n % i == 0:
            return False
        i += w
        w = 6 - w
    return True

m = 10**9 +7
def my_fact(n):
    ans = 1
    for i in range(1,n+1):
        ans = (ans%m * i%m)%m
    return ans

def main():
    n = int(input())
    ans = (my_fact(n) % m - pow(2, n - 1, m) % m + m) % m
    print(ans)


TestCases = False

if TestCases:
    for i in range(get_int()):
        main()
else:
    main()
