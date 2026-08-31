import bisect
import sys
import math
input = sys.stdin.readline
import functools

from collections import defaultdict

############ ---- Input Functions ---- ############

def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))

############ ---- Solution ---- ############

def solve(case):
    n = inp()
    M = 10 ** 9 + 7

    total = 1
    for i in range(n):
        total = (total * (n-i)) % M

    no_cycle = 1
    for i in range(n-1):
        no_cycle = (no_cycle * 2) % M

    return (total + M - no_cycle) % M
    

if len(sys.argv) > 1 and sys.argv[1].startswith("input"):
    f = open("./" + sys.argv[1], 'r')
    input = f.readline

res = solve(0)
print(str(res))
