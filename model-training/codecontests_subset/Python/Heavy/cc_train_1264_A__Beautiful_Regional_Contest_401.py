#!/usr/bin/env python3
from itertools import combinations
import sys
input = sys.stdin.readline
INF = 10**9

t = int(input())
for i in range(t):
    n = int(input())
    a = [int(item) for item in input().split()]
    miss_medal = a[n // 2]
    lim = a.index(miss_medal)
    g = a[0]
    s = -1
    g_cnt = 0
    s_cnt = 0
    b_cnt = 0
    state = 0
    for i in range(lim):
        if state == 0:
            if a[i] == g:
                g_cnt += 1
            else:
                s = a[i]
                s_cnt += 1
                state = 1
            continue
        if state == 1:
            if a[i] == s:
                s_cnt += 1
            elif s_cnt <= g_cnt:
                s = a[i]
                s_cnt += 1
            else:
                b = a[i]
                b_cnt += 1
                state = 2
                continue
        if state == 2:
            b_cnt = lim - i + 1
            break
    if g_cnt < s_cnt and g_cnt < b_cnt:
        print(g_cnt, s_cnt, b_cnt)
    else:
        print(0, 0, 0)