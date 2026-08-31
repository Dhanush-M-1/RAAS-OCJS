from collections import defaultdict, Counter
from itertools import product, groupby, count, permutations, combinations
from math import pi, sqrt, sin, cos, ceil, floor
from collections import deque
from bisect import bisect, bisect_left, bisect_right
from string import ascii_lowercase
from functools import lru_cache
import sys
sys.setrecursionlimit(1000000000)
INF = float("inf")
YES, Yes, yes, NO, No, no = "YES", "Yes", "yes", "NO", "No", "no"
dy4, dx4 = [0, 1, 0, -1], [1, 0, -1, 0]
dy8, dx8 = [0, -1, 0, 1, 1, -1, -1, 1], [1, 0, -1, 0, 1, 1, -1, -1]


def inside(y, x, H, W):
    return 0 <= y < H and 0 <= x < W


def ceil(a, b):
    return (a + b - 1) // b


# aとbの最大公約数
def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


# aとbの最小公倍数
def lcm(a, b):
    g = gcd(a, b)
    return a / g * b


def euclidean_distance(y1, x1, y2, x2):
    return sqrt((y1 - y2) ** 2 + (x1 - x2) ** 2)


def manhattan_distance(y1, x1, y2, x2):
    return abs(y1 - y2) + abs(x1 - x2)


def main():
    N = int(input())
    A = list(map(int, input().split()))

    even, odd = [], []
    for a in A:
        if a % 2 == 0:
            even.append(a)
        else:
            odd.append(a)

    even.sort()
    odd.sort()

    num_even = len(even)
    num_odd = len(odd)
    if abs(num_even - num_odd) <= 1:
        ans = 0
    elif num_even > num_odd:
        ans = 0
        for i in range(num_even - num_odd - 1):
            ans += even[i]
    else:
        ans = 0
        for i in range(num_odd - num_even - 1):
            ans += odd[i]
    print(ans)


if __name__ == '__main__':
    main()
