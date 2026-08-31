#!/usr/bin/env python3

from math import *
from itertools import *
from collections import *
from bisect import *


if __name__ == '__main__':
    n = int(input())
    s = input()
    ones = s.count('1')
    zeroes = n-ones
    if ones != zeroes:
        print(1)
        print(s)
    else:
        for i in range(1,n+1):
            ao = s[:i].count('1')
            az = i-ao
            if ao != az and ones-ao != zeroes-az:
                print(2)
                print(s[:i], s[i:])
                break
