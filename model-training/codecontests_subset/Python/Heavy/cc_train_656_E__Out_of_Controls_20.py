#!/usr/bin/python3

import sys
sys.setrecursionlimit(10000)

n = int(input())

a = []

def read(i):
    try:
        1 / (n - i)
        a.append(list(map(int, input().split())))
        read(i + 1);
    except:
        pass

def f(i, j, k):
    try:
        1 / (n - i)
        1 / (n - j)
        1 / (n - k)
        a[j][k] = min(a[j][k], a[j][i] + a[i][k])
        f(i, j, k + 1)
    except:
        try:
            1 / (n - i)
            1 / (n - j)
            f(i, j + 1, 0)
        except:
            try:
                1 / (n - i)
                f(i + 1, 0, 0)
            except:
                pass

def m(i):
    try:
        1 / (n - i)
        return max(max(a[i]), m(i + 1))
    except:
        return 0

read(0)
f(0, 0, 0)
print(m(0))
