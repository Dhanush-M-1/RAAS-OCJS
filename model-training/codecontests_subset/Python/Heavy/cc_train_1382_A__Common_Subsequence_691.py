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


# input = sys.stdin.buffer.readline

def index(a, x):
    i = bisect.bisect_left(a, x)
    if i != len(a) and a[i] == x:
        return -1
    return i


#############
# MAIN CODE #
#############
for _ in range(int(input())):
    n, m = getNM()
    a = getList()
    b = getList()

    ans = []
    for x in a:
        if x in b:
            ans.append(x)
            break
    if ans:
        print("YES")
        print(len(ans), *ans)
    else:
        print("NO")
