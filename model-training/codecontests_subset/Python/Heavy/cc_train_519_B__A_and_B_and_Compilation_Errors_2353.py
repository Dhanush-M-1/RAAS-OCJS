#!/usr/bin/env python3
"""
Codeforces
519 B. A and B and Compilation Errors

@author yamaton
@date 2015-08-05
      2015-09-22
"""
import collections

def solve(xs, ys, zs):
    sum_x = sum(xs)
    sum_y = sum(ys)
    sum_z = sum(zs)
    return (sum_x - sum_y, sum_y - sum_z)

# def solve(xs, ys, zs):
#     xcnt = set(collections.Counter(xs).items())
#     ycnt = set(collections.Counter(ys).items())
#     zcnt = set(collections.Counter(zs).items())
#     fst, _ = (xcnt - ycnt).pop()
#     snd, _ = (ycnt - zcnt).pop()
#     return fst, snd



def main():
    n = int(input())
    xs = [int(i) for i in input().strip().split()]
    ys = [int(i) for i in input().strip().split()]
    zs = [int(i) for i in input().strip().split()]        
    assert n == len(xs) == len(ys) + 1 == len(zs) + 2
    result = solve(xs, ys, zs)
    for out in result:
        print(out)


if __name__ == '__main__':
    main()
