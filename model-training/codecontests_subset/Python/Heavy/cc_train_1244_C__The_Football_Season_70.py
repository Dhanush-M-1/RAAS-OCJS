#!/usr/bin/env python3
import sys
from math import *

#lines = stdin.readlines()
def rint():
    return map(int, sys.stdin.readline().split())

def input():
    return sys.stdin.readline().rstrip('\n')

def oint():
    return int(input())

"""
x: num of wins
y: num of draws
z: num of loses
n: played game
p: point
w: point for win
d: point for draw
"""
n, p, w, d = rint()

for y in range(w+1):
    #w*x = p - d*y
    if (p-d*y)%w:
        continue
    x= (p-d*y)//w
    #print(x, y)
    if x + y <= n and x >= 0:
        print(x, y, n-x-y)
        exit()
print(-1)



