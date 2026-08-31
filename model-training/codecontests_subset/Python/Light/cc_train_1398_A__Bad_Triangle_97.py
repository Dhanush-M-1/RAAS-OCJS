import sys
input = sys.stdin.readline
from collections import *

for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    x, y, z = a[0], a[1], a[-1]
    
    if z>=x+y:
        print(1, 2, n)
    else:
        print(-1)