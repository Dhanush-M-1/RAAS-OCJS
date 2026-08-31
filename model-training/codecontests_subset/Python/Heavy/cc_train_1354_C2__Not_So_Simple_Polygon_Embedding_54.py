import math
import sys
from collections import defaultdict
from collections import deque
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
ilele = lambda: map(int,input().split())
alele = lambda: list(map(int, input().split()))
def list2d(a, b, c): return [[c] * b for i in range(a)]
def list3d(a, b, c, d): return [[[d] * c for j in range(b)] for i in range(a)]
INF = 10 ** 18
MOD = 1000000000 + 7

for _ in range(int(input())):
    N = int(input())*2
    a = math.cos(math.pi/(2*N))
    b = math.sin(math.pi/N)
    print(a/b)