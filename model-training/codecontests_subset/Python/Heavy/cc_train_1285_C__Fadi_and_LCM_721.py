import sys, collections, math, itertools, random, bisect
INF = sys.maxsize
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def get_array(): return list(map(int, sys.stdin.readline().strip().split()))
def input(): return sys.stdin.readline().strip()
mod = int(1e9+7)

def lcm(a, b):
    return (a // math.gcd(a, b) * b)

n = int(input())
if not n&(n-1):
    print(1, n)
else:
    cnt = 0
    for i in range(1, int(math.sqrt(n))+1):
        if lcm(i, n//i) == n:
            cnt = i
    print(cnt, n//cnt)
