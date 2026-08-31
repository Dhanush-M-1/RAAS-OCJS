import sys
import math
import itertools
import functools
import collections
import operator
import fileinput
import copy
from collections import *
 
ORDA = 97  # a
def ii(): return int(input())
def mi(): return map(int, input().split())
def li(): return [int(i) for i in input().split()]
def lcm(a, b): return abs(a * b) // math.gcd(a, b)
def revn(n): return str(n)[::-1]
def dd(): return collections.defaultdict(int)
def ddl(): return collections.defaultdict(list)
def sieve(n):
    if n < 2: return list()
    prime = [True for _ in range(n + 1)]
    p = 3
    while p * p <= n:
        if prime[p]:
            for i in range(p * 2, n + 1, p):
                prime[i] = False
        p += 2
    r = [2]
    for p in range(3, n + 1, 2):
        if prime[p]:
            r.append(p)
    return r
def divs(n, start=2):
    r = []
    for i in range(start, int(math.sqrt(n) + 1)):
        if (n % i == 0):
            if (n / i == i):
                r.append(i)
            else:
                r.extend([i, n // i])
    return r
def divn(n, primes):
    divs_number = 1
    for i in primes:
        if n == 1:
            return divs_number
        t = 1
        while n % i == 0:
            t += 1
            n //= i
        divs_number *= t
def prime(n):
    if n == 2: return True
    if n % 2 == 0 or n <= 1: return False
    sqr = int(math.sqrt(n)) + 1
    for d in range(3, sqr, 2):
        if n % d == 0: return False
    return True
def convn(number, base):
    new_number = 0
    while number > 0:
        new_number += number % base
        number //= base
    return new_number
def cdiv(n, k): return n // k + (n % k != 0)
def ispal(s): # Palindrome
    for i in range(len(s) // 2 + 1):
        if s[i] != s[-i - 1]:
            return False
    return True
# a = [1,2,3,4,5] -----> print(*a) ----> list print krne ka new way
		

def main():
	for _ in range(int(input())):
	    n = int(input())
	    arr = [list(input()) for _ in range(n)]
	    res = []
	    if arr[n-2][n-1] == arr[n-1][n-2]:
	        if arr[0][1] == arr[n-2][n-1]:
	            res.append((1, 2))
	        if arr[1][0] == arr[n-2][n-1]:
	            res.append((2, 1))
	    elif arr[0][1] == arr[1][0]:
	        if arr[n-2][n-1] == arr[0][1]:
	            res.append((n-1, n))
	        if arr[n-1][n-2] == arr[0][1]:
	            res.append((n, n-1))
	    else:
	        if arr[0][1] == "1":
	            res.append((1, 2))
	        if arr[1][0] == "1":
	            res.append((2, 1))
	        if arr[n-2][n-1] == "0":
	            res.append((n-1, n))
	        if arr[n-1][n-2] == "0":
	            res.append((n, n-1))
	    print(len(res))
	    for e in res:
	        print(*e)
main()