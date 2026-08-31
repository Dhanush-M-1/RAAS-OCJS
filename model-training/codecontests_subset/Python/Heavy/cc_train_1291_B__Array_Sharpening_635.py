#! /usr/bin/env python
# -*- coding: utf-8 -*-
# vim:fenc=tf-8
#

"""
"""

from operator import itemgetter
from collections import Counter

def solve(a):
    n = len(a)
    flag = False
    for i in range(n):
        if a[i] < i and not flag:
            flag = True
            a[i] = min(a[i],a[i-1]-1)
        if flag and a[i]<(n-1)-i:
            print("No")
            return 0
    print("Yes")
            

def main():
    t= int(input())
    for i in range(t):
        input()
        a = list(map(int,input().split()))
        solve(a)


if __name__ == "__main__":
    main()