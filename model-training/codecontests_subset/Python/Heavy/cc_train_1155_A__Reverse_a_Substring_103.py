#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""Codeforces Educational Round #63 (Div. 2)

Problem A. Reverse a Substring

:author:         Kitchen Tong
:mail:    kctong529@gmail.com

Please feel free to contact me if you have any question
regarding the implementation below.
"""

__version__ = '0.1'
__date__ = '2019-04-23'

import sys
import string


def solve(n, s):
    for i in range(1, n):
        if s[i] < s[i-1]:
            return i
    return -1

def main(argv=None):
    n = int(input())
    s = input()
    answer = solve(n, s)
    if answer >= 0:
        print('YES')
        print(answer, answer+1)
    else:
        print('NO')
    return 0

if __name__ == "__main__":
    STATUS = main()
    sys.exit(STATUS)

