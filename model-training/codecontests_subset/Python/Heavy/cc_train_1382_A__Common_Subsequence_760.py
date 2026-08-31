# ########## ------ Import ------- ##########

from sys import maxsize, stdin
from math import log, pow, sqrt, floor, ceil, pi
from collections import Counter, defaultdict
from collections import deque as deq
from functools import lru_cache
from itertools import permutations as perm
from itertools import combinations as comb
from itertools import combinations_with_replacement as combr

# ########## ------ Define -------- #########

INT_MAX = maxsize
INT_MIN = -INT_MAX
PI = pi
MOD = 1000000007

# ########## ------ Input Functions ---- #########

input = stdin.readline


def inp():
    return(int(input()))


def inlt():
    return(list(map(int, input().split())))


def insr():
    s = input()
    return(list(s[:len(s) - 1]))


def invr():
    return(map(int, input().split()))


# ########## ------ Code ------- ##########


t = inp()
while t:

    n = inlt()
    a = inlt()
    b = inlt()

    c = set(b)
    
    found = False
    ans = 0
    for i in a:
        if i in c:
            found = True
            ans = i
            break
    if found:
        print("YES")
        print(1,ans)

    else:
        print("NO")
    t -= 1
