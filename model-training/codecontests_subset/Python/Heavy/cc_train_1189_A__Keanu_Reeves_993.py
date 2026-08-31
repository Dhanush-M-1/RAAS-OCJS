import sys
from collections import Counter
import itertools
from math import floor, ceil

def input():
    return sys.stdin.readline().strip()

def dinput():
    return int(input())

def tinput():
    return input().split()

def rinput():
    return map(int, tinput())

def rt(x1, x2, y3):
    print(0.5*(x2+x1))

def main():
    n = int(input())
    r = input()
    t = r.count("0")
    if t == n - t:
        print(2)
        print(r[:-1], r[-1])
    else:
        print(1)
        print(r)
main()
