import sys,math,itertools
from collections import Counter,deque,defaultdict
from bisect import bisect_left,bisect_right 
mod = 10**9+7
INF = float('inf')
def inp(): return int(sys.stdin.readline())
def inpl(): return list(map(int, sys.stdin.readline().split()))

for _ in range(inp()):
    n = inp()
    a = inpl()
    c = Counter(a)
    tmp = list(c)
    tmp.sort(reverse = True)
    cnt = 0
    per = []
    for key in tmp:
        if c[key] + cnt > n//2:
            break
        cnt += c[key]
        per.append(c[key])
    ln = len(per)
    if ln < 3:
        print(0,0,0)
        continue
    gold = per[0]
    bronze = sum(per) - gold
    silver = 0
    for i in range(1,ln-1):
        silver += per[i]
        bronze -= per[i]
        if silver > gold and bronze > gold:
            break
    else:
        print(0,0,0)
        continue
    print(gold,silver,bronze)