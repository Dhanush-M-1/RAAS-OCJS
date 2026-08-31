import os

import sys

debug = True

if debug and os.path.exists("input.in"):
    input = open("input.in", "r").readline
else:
    debug = False
    input = sys.stdin.readline


def inp():
    return (int(input()))


def inlt():
    return (list(map(int, input().split())))


def insr():
    s = input()
    return s[:len(s) - 1]  # Remove line char from end


def invr():
    return (map(int, input().split()))


test_count = int(input())

for t in range(test_count):
    if debug:
        print("Test Case #", t + 1)
    # Start code here
    n = inp()
    if n == 1:
        print(0)
    elif n % 3 != 0:
        print(-1)
    else:
        threes = 0
        while n % 3 == 0:
            threes += 1
            n = n // 3
        twos = 0
        while n % 2 == 0:
            twos += 1
            n = n // 2
        if n != 1 or twos > threes:
            print(-1)
        else:
            print(threes - twos + threes)
