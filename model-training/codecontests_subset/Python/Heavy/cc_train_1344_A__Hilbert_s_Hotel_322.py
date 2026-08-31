import sys
import math
import bisect
from sys import stdin, stdout
from math import gcd, floor, sqrt, log2, ceil
from collections import defaultdict
from bisect import bisect_left as bl, bisect_right as br
from collections import Counter
from collections import deque
 
ip = lambda : int(stdin.readline())
inp = lambda: map(int,stdin.readline().split())
ips = lambda: stdin.readline().rstrip()

t = ip()
for _ in range(t):
    n = ip()
    arr = list(inp())
    bol = [False]*n
    for i in range(n):
        pos = (i+arr[i])%n
        bol[pos] = True
    if bol.count(True) == n:
        print("YES")
    else:
        print("NO")
