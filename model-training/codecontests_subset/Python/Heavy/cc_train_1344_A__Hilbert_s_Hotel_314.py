import math
import sys
from collections import defaultdict,Counter,deque,OrderedDict
import bisect
#sys.setrecursionlimit(1000000)
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
ilele = lambda: map(int,input().split())
alele = lambda: list(map(int, input().split()))
def list2d(a, b, c): return [[c] * b for i in range(a)]
#def list3d(a, b, c, d): return [[[d] * c for j in range(b)] for i in range(a)]
#INF = 10 ** 18
#MOD = 1000000000 + 7
from itertools import accumulate,groupby


for _ in range(int(input())):
    N = int(input())
    A = alele()
    M = [0]*N
    for i in range(N):
        M[((A[i]%N)+i)%N] = 1
    if 0 in M:
        print("NO")
    else:
        print("YES")