#!/usr/bin/env python3

def solve(n, rs):
    if len(rs) == 1:
        return rs[0][0] >= rs[0][1] and rs[0][0] >= 0 and rs[0][1] >= 0
    for r1, r2 in zip(rs, rs[1:]):
        if r1[0] < 0 or r1[1] < 0 or r2[0] < 0 or r2[1] < 0:
            return False
        diff_p = r2[0] - r1[0]
        diff_c = r2[1] - r1[1]
        if r1[0] < r1[1] or r2[0] < r2[1]:
            return False
        if diff_c < 0 or diff_p < 0:
            return False
        if diff_c > diff_p:
            return False
    return True


T = int(input())
for _ in range(T):
    n = int(input())
    records = []
    for _ in range(n):
        p, c = (int(i) for i in input().split())
        records.append((p, c))
    if solve(n, records):
        print('YES')
    else:
        print('NO')
