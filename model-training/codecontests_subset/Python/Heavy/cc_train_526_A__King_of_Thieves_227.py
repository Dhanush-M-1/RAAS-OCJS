import math
from collections import *
from functools import reduce,cmp_to_key
import sys
input = sys.stdin.readline
M = mod = 10**9 + 7
def factors(n):return sorted(list(set(reduce(list.__add__,([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0)))))
def inv_mod(n):return pow(n, mod - 2, mod)

def li():return [int(i) for i in input().rstrip('\n')]
def st():return input().rstrip('\n')
def val():return int(input())

def solve():
    for i in range(len(s)):
        if s[i] == '*':
            for j in range(i):
                try:
                    if s[i+3*(i-j)] == '*' and s[j] == '*' and s[i+(i-j)] == '*' and s[i + 2*(i-j)] == '*':
                        return 'yes'
                except:continue
    return 'no'
n = val()
s = st()
print(solve())