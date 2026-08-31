#!/usr/bin/env python3
import sys

#lines = stdin.readlines()
def rint():
    return map(int, sys.stdin.readline().split())

def input():
    return sys.stdin.readline().rstrip('\n')

def oint():
    return int(input())


t = oint()

for _ in range(t):
    n, m = rint()
    ss = input()
    p = list(rint())
    p.sort()
    s = []
    for i in range(n):
        s.append(ord(ss[i])- ord('a'))

    cnt = [0]*26
    ans = [0]*26
    #print("s m cnt")
    #print(s)
    #print(m)
    #print(cnt)
    #print("p")
    #print(p)
    i0 = 0
    for i in range(m):
        for ii in range(i0, p[i]):
            cnt[s[ii]] += 1
        i0 = p[i]
        for ii in range(26):
            ans[ii] += cnt[ii]
    for i in range(i0, n):
        cnt[s[i]] += 1
    for i in range(26):
        ans[i] += cnt[i]
    #print("cnt")
    #print(cnt)
    #print("ans")
    print(*ans)


