import math
from fractions import Fraction as frac

MOD = 1e9 + 7

def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)

def lcm(a, b):
    return a * b // gcd(a, b)

def no():
    print("NO")
    return

def yes():
    print("YES")
    return

def solve(case_no):
    a = list(map(int, input().split('+')))
    a.sort()
    print(a[0], end = "")
    for i in range(1, len(a)):
        print("+", end = "")
        print(a[i], end = "")

t = 1
# t = int(input())
for i in range(1, t + 1):
    solve(i)
