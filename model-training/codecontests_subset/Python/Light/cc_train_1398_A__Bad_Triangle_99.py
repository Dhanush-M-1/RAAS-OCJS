# -*- coding: utf-8 -*-
"""
Created on Mon Aug  3 21:10:40 2020

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

for case in range(int(input())):
    n = int(input())
    a = [int(x) for x in input().split()]
    if a[0] + a[1] <= a[-1]:
        print(1, 2, n)
    else:
        print(-1)
