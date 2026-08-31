#!/usr/bin/env python3
import io
import os

input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

def get_str():
    return input().decode().strip()

def rint():
    return map(int, input().split())

def oint():
    return int(input())

n, k = rint()
tab = []
for i in range(n):
    tab.append(tuple(rint()))
tab.sort()

ai = []
bi = []
bc = 0
tot_time = 0
ka = 0
kb = 0
for i in range(n):
    t, a, b = tab[i]
    if a and not b:
        if ka < k:
            ka += 1
            ai.append(i)
            tot_time += t
    elif b and not a:
        if kb < k:
            kb += 1
            bi.append(i)
            tot_time += t
    elif a and b:
        if ka < k or kb < k:
            ka += 1
            kb += 1
            tot_time += t
            if ka > k:
                if len(ai):
                    ta = tab[ai.pop()][0]
                    tot_time -= ta
                    ka -= 1
            if kb > k:
                if len(bi):
                    tb = tab[bi.pop()][0]
                    tot_time -= tb
                    kb -= 1
        elif ka >= k and kb >= k:
            if len(ai) and len(bi):
                ta = tab[ai.pop()][0]
                tb = tab[bi.pop()][0]
                if t < ta + tb:
                    tot_time = tot_time - ta - tb + t

if ka >= k and kb >= k:
    print(tot_time)
else:
    print(-1)


