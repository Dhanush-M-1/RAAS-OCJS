import math
import os
import sys

import re

import itertools
import functools
import operator

def res(a, b, c):
    return a + res((a + c)//b, b, (a + c)%b) if a != 0 else 0

a, b = map(int, input().split())
print(res(a, b, 0))