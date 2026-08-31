import sys
import math
import collections
import heapq

def set_debug(debug_mode=False):
    if debug_mode:
        fin = open('input.txt', 'r')
        sys.stdin = fin


def int_input():
    return list(map(int, input().split()))


if __name__ == '__main__':
    # set_debug(True)

    # t = int(input())
    t = 1

    for ti in range(1, t + 1):
        n, k = int_input()
        both = []
        Ab = []
        Bb = []
        A = 0
        B = 0

        for _ in range(n):
            t, a, b = int_input()
            if a == 1 and b == 1:
                both.append(t)
            elif a == 1:
                Ab.append(t)
            elif b == 1:
                Bb.append(t)

        Ab.sort()
        Bb.sort()

        for i in range(min(len(Ab), len(Bb))):
            both.append(Ab[i] + Bb[i])

        print(-1 if len(both) < k else sum(sorted(both)[:k]))
