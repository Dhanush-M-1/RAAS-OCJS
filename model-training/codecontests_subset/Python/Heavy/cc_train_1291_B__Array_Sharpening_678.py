#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb  2 15:22:17 2020

@author: dennis
"""

import atexit
import io
import sys

_INPUT_LINES = sys.stdin.read().splitlines()
input = iter(_INPUT_LINES).__next__
_OUTPUT_BUFFER = io.StringIO()
sys.stdout = _OUTPUT_BUFFER

@atexit.register
def write():
    sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())

def main(a):
    force_decrease = False
    peak = -1
    for i, x in enumerate(a):
        if force_decrease:
            if x >= peak:
                x = peak-1
                peak = x
            if (x < len(a)-i-1):
                return False
        else:
            if x < i:
                force_decrease = True
                peak = a[i-1]
                if x >= peak:
                    x = peak-1
                    peak = x
                if (x < len(a)-i-1):
                    return False
    return True

for _ in range(int(input())):
    n = int(input())
    a = [int(x) for x in input().split()]
    if main(a):
        print('Yes')
    else:
        print('No')
