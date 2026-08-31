#!/usr/bin/env python3
from sys import stdin
import operator


def solve(tc):
    n = int(stdin.readline().strip())
    s = stdin.readline().strip()

    dic = {}
    for i in range(1,n):
        sub = s[i-1] + s[i]
        if sub in dic:
            dic[sub] += 1
        else:
            dic[sub] = 1
        
    print(max(dic.items(), key=operator.itemgetter(1))[0])


LOCAL_TEST = not __debug__
if LOCAL_TEST:
    infile = __file__.split('.')[0] + "-test.in"
    stdin = open(infile, 'r')

tcs = (int(stdin.readline().strip()) if LOCAL_TEST else 1)
tc = 1
while tc <= tcs:
    solve(tc)
    tc += 1