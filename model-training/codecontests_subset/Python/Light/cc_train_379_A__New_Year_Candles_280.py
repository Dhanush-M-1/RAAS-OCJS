from sys import stdin,stdout
from math import ceil,floor,sqrt
from collections import deque,Counter
inp = stdin.readline
out = stdout.write

a,b=map(int,inp().strip().split())
c=(a*b-1)//(b-1)
print(c)