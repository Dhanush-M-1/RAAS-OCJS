#!/usr/bin/env python3
# -*- coding: utf-8 -*-
#
# 解説pdf https://img.atcoder.jp/agc026/editorial.pdf を見た



import array
from bisect import *
from collections import *
import fractions
import heapq 
from itertools import *
import math
import random
import re
import string
import sys


def gcd(a, b):
    while b:
        a, b = b, a % b
    return a



def solve(A, B, C, D):
    if B > A:
        return "No"
    if B > D:
        return "No"
    if B <= C:
        return "Yes"

    g = gcd(B, D)
    if B - g + (A % g) > C:
        return "No"
    else:
        return "Yes"


T = int(input())
for t in range(T):
    A, B, C, D = map(int, input().split())
    print(solve(A, B, C, D))
    

