#!/usr/bin/env python3
import sys

def rint():
    return map(int, sys.stdin.readline().split())
#lines = stdin.readlines()

q = int(input())

for i in range(q):
    l, r, d = rint()
    if l > d:
        print(d)
    else:
        if r%d == 0:
            print(r+d)
        else:
            print((r//d)*d+d)