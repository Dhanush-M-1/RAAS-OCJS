#!/usr/bin/env python3
from sys import stdin


def solve(tc):
    n, m = map(int, stdin.readline().split())
    s = stdin.readline()
    plist = list(map(int, stdin.readline().split()))

    cum = [0 for i in range(n + 1)]
    ans = [0 for i in range(26)]
    for p in plist:
        cum[0] += 1
        cum[p] -= 1

    for i in range(1, n):
        cum[i] += cum[i - 1]

    for i in range(n):
        ans[ord(s[i]) - ord('a')] += cum[i] + 1

    for i in range(26):
        print(ans[i], end=' ')
    print('\n')


LOCAL_TEST = not __debug__
if LOCAL_TEST:
    infile = __file__.split('.')[0] + "-test.in"
    stdin = open(infile, 'r')

tcs = int(stdin.readline().strip())
tc = 1
while tc <= tcs:
    solve(tc)
    tc += 1