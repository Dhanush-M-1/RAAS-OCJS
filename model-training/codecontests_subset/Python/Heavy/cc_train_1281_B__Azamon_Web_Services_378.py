import sys
import bisect
# import heapq
from math import ceil,floor


RI = lambda : [int(x) for x in sys.stdin.readline().split()]
ri = lambda : sys.stdin.readline().strip()
mod = 10**9+7
# for _ in range(int(ri())):

n = int(ri())
for i in range(n):
    st = ri().split()

    temp = sorted(st[0])
    s = list(st[0])
    flag = True
    for i in range(len(s)):
        if temp[i] != s[i]:
            for j in range(len(s)-1,i,-1):
                if s[j] == temp[i]:
                    s[i],s[j] = s[j],s[i]
                    flag = not flag
                    break
        if not flag :
            break

    st1 = "".join(s)
    st2 = st[1]
    # print(st1,st2)
    if st1 < st2:
        print(st1)
    else:
        print("---")