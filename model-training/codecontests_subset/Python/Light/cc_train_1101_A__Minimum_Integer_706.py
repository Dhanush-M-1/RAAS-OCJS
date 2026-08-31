import math


def get_min(l, r, d):
    cur = d
    if l <= cur <= r:
        cur = (r // d) * d + d
    return cur


if __name__ == '__main__':
    n = int(input())
    for i in range(n):
        l, r, d = list(map(int, input().split()))
        print(get_min(l, r, d))
