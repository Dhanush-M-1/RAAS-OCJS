from sys import stdin
from collections import deque
from math import sqrt, floor, ceil, log, log2, log10, pi, gcd, sin, cos, asin
def ii(): return int(stdin.readline())
def fi(): return float(stdin.readline())
def mi(): return map(int, stdin.readline().split())
def fmi(): return map(float, stdin.readline().split())
def li(): return list(mi())
def lsi():
    x=list(stdin.readline())
    x.pop()
    return x
def si(): return stdin.readline()
res=['YES', 'NO']
############# CODE STARTS HERE #############
for _ in range(ii()):
    f=0
    p=c=0
    for _ in range(ii()):
        x, y=mi()
        if x<p or y<c:
            f=1
        elif y-c>x-p:
            f=1
        p, c=x, y
        if p<c:
            f=1
    print(res[f])