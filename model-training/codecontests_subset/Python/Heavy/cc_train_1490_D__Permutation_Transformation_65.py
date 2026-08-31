import sys, collections, math, itertools, random, bisect
INF = sys.maxsize
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def get_array(): return list(map(int, sys.stdin.readline().strip().split()))
def input(): return sys.stdin.readline().strip()
mod = 1000000007

m = collections.defaultdict(int)

def mt(arr, left, n, curr):
    if left <= n and n >= 0:
        mx = -INF
        mxi = 0
        for i in range(left, n+1):
            if arr[i] > mx:
                mx = arr[i]
                mxi = i
        mt(arr, left, mxi-1, curr+1)
        mt(arr, mxi+1, n, curr+1)
        m[arr[mxi]] = curr

for _ in range(int(input())):
    m = collections.defaultdict(int)
    n = int(input())
    arr = get_array()
    mxi = 0
    mx = -INF
    for i in range(n):
        if arr[i] > mx:
            mx = arr[i]
            mxi = i
    m[arr[mxi]] = 0
    mt(arr, 0, mxi-1, 1)
    mt(arr, mxi+1, n-1, 1)
    for i in range(n):
        print(m[arr[i]], end=' ')
    print()