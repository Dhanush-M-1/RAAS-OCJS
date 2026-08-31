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


test_count = 1
if debug:
    test_count = inp()

for t in range(test_count):
    if debug:
        print("Test Case #", t + 1)
    # Start code here
    n = inp()
    a = insr()
    ans = 0
    ans_g = ""
    freq = {}
    for i in range(n - 1):
        g = a[i:i + 2]
        if g not in freq:
            freq[g] = 1
        else:
            freq[g] = freq[g] + 1
        if freq[g] > ans:
            ans = freq[g]
            ans_g = g
    print(ans_g)
