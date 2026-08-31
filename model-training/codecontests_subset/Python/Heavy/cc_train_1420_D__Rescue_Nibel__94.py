from math import factorial as f
from heapq import heappush, heappop

import sys
def inp(): return sys.stdin.buffer.readline().rstrip()
def inpa(): return tuple(map(int, inp().split()))
def out(var): sys.stdout.write(str(var)+"\n")
def outa(var): sys.stdout.write(' '.join(map(str, var))+'\n')

def setup():
    import os, sys
    dir_path = os.path.dirname(os.path.realpath(__file__))
    sys.stdin = open(os.path.join(dir_path, "input.txt"), 'r')
    sys.stdout = open(os.path.join(dir_path, "output.txt"), 'w')
#setup()

# Note if k lamps intersect, they must also intersect
# on the one that ends the earliest

# O(n^2):
# for each lamp end time e: 
#     find all lamps whose [l,r] which contain end time
#     choose k of those as our lamps, including at least 
#           one lamp that just ended. 
#     Vandermonde's Identity to sum up binomial coeff.
#       If m lamps (not ending at e) and n lamps (ending at e),
#          number of ways is (m+n choose k) - (m choose k)
# Note: each situation is non intersecting


# O(nlogn): sort by end time
# in ascending start order, push lamps to heapq
# heapq sorts by end time, pop those w earliest end times
# each turn takes logn time
# for each turn, you can use number of elements in heapq
#   also keep track of num of elements at some end time 

def C(n,k):
    return (fac[n] * invf[n-k] * invf[k]) % mod if n >= k else 0

MAXN = 3 * 10**5
# mod is prime, lets us use FLT
mod = 998244353

# pow(x, e, m) uses binary exponentiation
# have to precompute factorial and inverse factorial because it can be VERY large and slow
fac = [1]
for i in range(1, MAXN + 1):
    fac.append((fac[-1] * i) % mod)

# fac has array [0, ..., MAXN]
# invf[i] = (fac[i] ^ (mod-2)) % mod = (i+1) * invf[i+1] % mod

invf = [pow(fac[-1], mod-2, mod)]
for i in range(MAXN, 0, -1):
    invf.append( (i * invf[-1]) % mod )
invf = invf[::-1]


def solve(arr, size, k):
    a = [i[0] for i in arr]
    a.extend([i[1] for i in arr])
    times = sorted(set(a))
    arr.sort(key=lambda x: x[0])

    # idx keeps track of position in arr we are looking at
    ans = idx = 0

    # cur idx of array
    h = []
    for time in times:
        # push to heap
        while idx < size and arr[idx][0] == time:
            heappush(h, arr[idx][1])
            idx += 1

        # add and pop only when we reached the end of lamp
        # (to avoid double counting)
        if h[0] != time:
            continue

        # m is num of lamps (not ending at e)
        # n is num of lamps (ending at e)
        m, n = len(h), 0
        # pop items
        while h and h[0] == time:
            heappop(h)
            n += 1
        m -= n

        # have to include at least one of the lamps ending at this time
        if m+n >= k:
            ans += (C(m+n,k) - C(m,k)) % mod
    return ans % mod

n, k = inpa()
arr = [inpa() for _ in range(n)]
out(solve(arr, n, k))
