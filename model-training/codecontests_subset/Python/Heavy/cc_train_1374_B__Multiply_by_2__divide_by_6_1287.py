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
    three = 0
    two = 0
    while n % 3 == 0:
        n = n // 3
        three += 1
    while n % 2 == 0:
        n = n // 2
        two += 1

    if n != 1 or two > three:
        return -1

    return three + (three - two)
    

if len(sys.argv) > 1 and sys.argv[1].startswith("input"):
    f = open("./" + sys.argv[1], 'r')
    input = f.readline

T = inp()
for i in range(T):
    res = solve(i+1)
    print(str(res))
