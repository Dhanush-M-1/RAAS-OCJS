import sys
from collections import deque, defaultdict
input = sys.stdin.buffer.readline

n, k = map(int, input().split())
al, bl, cc = [], [], []
for _ in range(n):
    t, a, b = map(int, input().split())
    if a and not b: al.append(t)
    elif not a and b: bl.append(t)
    elif a and b: cc.append(t)
al.sort(); bl.sort()

for i in range(min(len(al), len(bl))):
    cc.append(al[i]+bl[i])
cc.sort()

if len(cc) < k: print(-1)
else: print(sum(cc[0:k]))
