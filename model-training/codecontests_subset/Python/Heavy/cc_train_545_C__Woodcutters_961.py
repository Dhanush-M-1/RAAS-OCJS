#!/usr/bin/env python3

# ------------------------------
# cs104c/assignment7/CutRibbon.py
# Copyright (C) 2017
# Drew Romanyk
# ------------------------------

# -------
# imports
# -------

import math
import sys


# -------
# solve
# -------

def solve(r, w):
    """
    :param r:
    :param w:
    :return:
    """
    trees = int(r.readline())
    data = []
    for _ in range(trees):
        line_data = [int(v) for v in r.readline().split()]
        data.append(line_data)

    result = 2
    for i in range(1, trees - 1):
        location, height = data[i]
        if location - height > data[i - 1][0]:
            result += 1
        elif location + height < data[i + 1][0]:
            result += 1
            data[i][0] += height

    print(result if trees > 1 else 1)


# -------
# main
# -------

if __name__ == "__main__":
    solve(sys.stdin, sys.stdout)
