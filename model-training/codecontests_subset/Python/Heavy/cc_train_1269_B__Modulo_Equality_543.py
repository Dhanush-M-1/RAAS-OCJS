#!/usr/bin/env python3
import sys

#lines = stdin.readlines()
def rint():
    return map(int, sys.stdin.readline().split())

def input():
    return sys.stdin.readline().rstrip('\n')

def oint():
    return int(input())


n, m = rint()

a = list(rint())
b = list(rint())
a.sort()
b.sort()

min_ans = 10**9
for i in range(n):
    prev = 0
    diff = 0
    #print("i", i)
    for j in range(n):
        bb = b[(i+j)%n]
        aa = a[j]
        diff = ((bb+m)%m - aa)%m
        #print("diff", diff)
        if j == 0:
            prev = diff
            continue
        else:
            if prev != diff:
                break
    else:
        min_ans = min(min_ans, diff%m)
print(min_ans)