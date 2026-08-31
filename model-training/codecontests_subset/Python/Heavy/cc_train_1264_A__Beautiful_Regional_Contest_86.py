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
    n = oint()
    p = list(rint())
    #print(p)
    s =[1]
    mid = n//2
    for i in range(1,mid):
        if p[i-1] == p[i]:
            s[-1] += 1
        else:
            s.append(1)
    if p[mid] == p[mid-1]:
        s.pop()

    #print(s)
    if len(s) < 3:
        print("0 0 0")
        continue
    gg = s[0]
    ss = 0
    bb = 0
    tot = sum(s[1:])
    for i in range(1, len(s)):
        ss += s[i]
        bb = tot - ss
        if gg < ss and gg < bb and bb > 0:
            break
    else:
        print("0 0 0")
        continue
    print(gg, ss, bb)



