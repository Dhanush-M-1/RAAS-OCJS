import sys
import math
def isprime(n):
    if n == 1:
        return False
    if n == 2:
        return True
    if n == 3:
        return True
    if (n % 2 == 0) or (n % 3 == 0):
        return False
    
    i = 5
    while i**2 <= n:
        if (n % i == 0) or (n % (i + 2)) == 0:
            return False
        i += 6
    
    return True

def largest_prime(n):
    for i in range(n, 1, -1):
        if isprime(i):
            return i
def lcm(a, b):
    return (a * b) // math.gcd(a, b)

def answer(n):
    if n == 1:
        return 1
    if n == 2:
        return 2
    if n == 3:
        return 6
    if n == 4:
        return 12
    if n % 2 == 1:
        return n * (n-1) * (n-2)
    if n == 6:
        return 60    
    
    return max( (n-1) * (n-2) * (n-3), lcm(n * (n-1), (n-3))) 


def main():
    n = int(sys.stdin.readline())
    print(answer(n))
    return
main()