#!/usr/bin/env python3
import sys
input = sys.stdin.readline

n, m = [int(item) for item in input().split()]
a = [int(item) for item in input().split()]
b = [int(item) for item in input().split()]
b.sort()

for item in a:
    a_mod = []
    for aa in a:
        a_mod.append((aa + m - item) % m)
    a_mod.sort()
    diff = b[0] - a_mod[0]
    ok = True
    for aa, bb in zip(a_mod, b):
        if bb - aa != diff:
            ok = False
            break
    if ok:
        print((diff - item + m) % m)
        exit()