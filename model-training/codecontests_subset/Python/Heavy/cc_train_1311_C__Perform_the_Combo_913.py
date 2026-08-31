from math import *

t = int(input())
for zz in range(t):
    n, m = map(int, input().split())
    s = input()
    p = [int(i) for i in input().split()]
    ts = 'abcdefghijklmnopqrstuvwxyz'
    p.append(n)
    d = {}
    for i in ts:
        d[i] = []
    for k in sorted(d.keys()):
        c = 0
        for i in range(n):
            if s[i] == k:
                c += 1
            d[k].append(c)
    ans = {}
    for i in ts:
        ans[i] = 0
    for ti in p:
        for k in d.keys():
            ans[k] += d[k][ti - 1]
            
    for i in sorted(ans.keys()):
        print(ans[i], end = ' ')
    print()
