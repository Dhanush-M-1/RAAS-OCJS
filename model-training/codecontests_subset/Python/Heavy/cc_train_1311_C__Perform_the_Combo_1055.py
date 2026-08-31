import math
import sys
from collections import defaultdict, Counter
from itertools import groupby

#input = sys.stdin.readline
rt = lambda: map(int, input().split())
ri = lambda: int(input())
rl = lambda: list(map(int, input().split()))


def main():
    t = ri()
    for _ in range(t):
        n, m = rt()
        s = input()
        p = rl()

        pref = [[0]*26 for _ in range(n)]

        for i in range(n):
            if i > 0:
                for j in range(26):
                    pref[i][j] += pref[i-1][j]
            pref[i][ord(s[i])-ord('a')] += 1

        all = pref[-1].copy()
        for i in range(m):
            for j in range(26):
                all[j] += pref[p[i]-1][j]

        print(*all)


if __name__ == '__main__':
    main()
