#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
codeforces
Level Statistics

Created on Fri Apr 10 09:38:12 2020

@author: mark
"""

TEST = False


def solve(vals):
    res = ['NO', 'YES']
    prev_p, prev_c = 0, 0
    prev_p, prev_c = 0, 0
    for p, c in vals:
        delta_p = p - prev_p
        delta_c = c - prev_c
        if p < c or p < prev_p or c < prev_c or delta_p < delta_c:
            return res[0]
        prev_p, prev_c = p, c
    return res[1]


s_in = '''
7
3
0 0
1 1
1 2
2
1 0
1000 3
4
10 1
15 2
10 2
15 2
1
765 432
2
4 4
4 3
5
0 0
1 0
1 0
1 0
1 0
3
0 0
2 1
2 2
'''

s_out = '''
NO
YES
NO
YES
NO
YES
NO
'''

l_in = list(reversed(s_in.split('\n')[1:-1]))
l_out = list(reversed(s_out.split('\n')[1:-1]))

if TEST:
    tc = []
    t = int(l_in.pop())
    for ti in range(t):
        n = int(l_in.pop())
        vals = []
        for ni in range(n):
            p, c = list(map(int, l_in.pop().split()))
            vals.append((p, c))
        sol = l_out.pop().strip()
        tc.append([vals, sol])
    print('\n*** tc ***')
    for test in tc:
        print(test)
    print('*** tc ***\n')

    for vals, sol in tc:
        res = solve(vals)
        print(res, sol, res == sol)

else:
    t = int(input())
    for ti in range(t):
        n = int(input())
        vals = []
        for ni in range(n):
            p, c = list(map(int, input().split()))
            vals.append((p, c))
        res = solve(vals)
        print(f'{res}')

