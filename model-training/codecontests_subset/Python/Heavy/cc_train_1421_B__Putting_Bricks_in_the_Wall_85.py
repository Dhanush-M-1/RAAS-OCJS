import sys
import math
from functools import reduce
import bisect


def getN():
    return int(input())


def getNM():
    return map(int, input().split())


def getList():
    return list(map(int, input().split()))


def input():
    return sys.stdin.readline().rstrip()


def index(a, x):
    i = bisect.bisect_left(a, x)
    if i != len(a) and a[i] == x:
        return i
    return False


#############
# MAIN CODE #
#############
for _ in range(getN()):
    n = getN()
    s = []
    for _ in range(n):
        s.append(list(input()))
    if {s[0][1], s[1][0]} == {s[n - 1][n - 2], s[n - 2][n - 1]} and len({s[0][1], s[1][0]}) == 1 and len(
            {s[n - 1][n - 2], s[n - 2][n - 1]}) == 1:
        print(2)
        print('1 2')
        print('2 1')
    elif s[0][1] != s[1][0] and s[n - 1][n - 2] != s[n - 2][n - 1]:
        if s[0][1] == s[n - 2][n - 1] and s[1][0] == s[n - 1][n - 2]:
            print(2)
            print('1 2')
            print(f'{n} {n - 1}')
        elif s[0][1] != s[n - 2][n - 1] and s[1][0] != s[n - 1][n - 2]:
            print(2)
            print('1 2')
            print(f'{n - 1} {n}')
    elif {s[0][1], s[1][0]} != {s[n - 1][n - 2], s[n - 2][n - 1]} and len({s[0][1], s[1][0]}) == 1 and len(
            {s[n - 1][n - 2], s[n - 2][n - 1]}) == 1:
        print(0)
    else:
        if s[0][1] == s[n - 1][n - 2] == s[n - 2][n - 1]:
            print(1)
            print(1, 2)
        elif s[1][0] == s[n - 1][n - 2] == s[n - 2][n - 1]:
            print(1)
            print(2, 1)

        if s[n - 1][n - 2] == s[0][1] == s[1][0]:
            print(1)
            print(f'{n} {n - 1}')
        elif s[n - 2][n - 1] == s[0][1] == s[1][0]:
            print(1)
            print(f'{n - 1} {n}')
