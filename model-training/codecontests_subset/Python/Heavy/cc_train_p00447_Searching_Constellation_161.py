# -*- coding: utf-8 -*-
"""
Searching Constellation
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0524

"""
import sys


def solve(targets, stars):
    for tx, ty in targets:
        for sx, sy in stars:
            dx, dy = sx-tx, sy-ty
            s_starts = set(stars)
            for x, y in targets:
                px, py = x+dx, y+dy
                if (px, py) in s_starts:
                    s_starts.remove((px, py))
                else:
                    break
            else:
                return dx, dy


def main(args):
    while True:
        m = int(input())
        if m == 0:
            break
        targets = [tuple(int(x) for x in input().split()) for _ in range(m)]
        n = int(input())
        stars = [tuple(int(x) for x in input().split()) for _ in range(n)]
        ans = solve(targets, stars)
        print(*ans)


if __name__ == '__main__':
    main(sys.argv[1:])

