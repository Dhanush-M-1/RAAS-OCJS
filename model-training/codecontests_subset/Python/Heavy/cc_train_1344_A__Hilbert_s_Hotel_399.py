def getN():
    return int(input())
def getNM():
    return map(int, input().split())
def getList():
    return list(map(int, input().split()))

from collections import defaultdict, deque
from sys import exit
import math
import copy
from bisect import bisect_left

import sys
# sys.setrecursionlimit(1000000)

def solve():
    n = getN()
    nums = getList()
    rooms = [0 for i in range(n)]
    for i, num in enumerate(nums):
        move = num % n
        if rooms[(i+move) % n] == 0:
            rooms[(i+move) % n] = 1
        else:
            print("NO")
            return
    print("YES")
    return

def main():
    n = getN()
    # print(-239 % 5)
    for _ in range(n):
        solve()

if __name__ == "__main__":
    main()

