"""
  ____          _      _____
 / ___|___   __| | ___|  ___|__  _ __ ___ ___  ___
| |   / _ \ / _` |/ _ \ |_ / _ \| '__/ __/ _ \/ __|
| |__| (_) | (_| |  __/  _| (_) | | | (_|  __/\__ \
 \____\___/ \__,_|\___|_|  \___/|_|  \___\___||___/
"""
"""
░░██▄░░░░░░░░░░░▄██
░▄▀░█▄░░░░░░░░▄█░░█░
░█░▄░█▄░░░░░░▄█░▄░█░
░█░██████████████▄█░
░█████▀▀████▀▀█████░
▄█▀█▀░░░████░░░▀▀███
██░░▀████▀▀████▀░░██
██░░░░█▀░░░░▀█░░░░██
███▄░░░░░░░░░░░░▄███
░▀███▄░░████░░▄███▀░
░░░▀██▄░▀██▀░▄██▀░░░
░░░░░░▀██████▀░░░░░░
░░░░░░░░░░░░░░░░░░░░
"""

import sys
import math
import collections
from collections import deque

#sys.stdin = open('input.txt', 'r')
#sys.stdout = open('output.txt', 'w')

from functools import reduce
from sys import stdin, stdout, setrecursionlimit
setrecursionlimit(2**20)


def factors(n):
    return list(set(reduce(list.__add__,
                           ([i, n // i] for i in range(1, int(n**0.5) + 1) if n % i == 0))))

# for _ in range(int(stdin.readline())):
#n = int(stdin.readline().strip('\n'))
# b = str(stdin.readline().strip('\n'))
# n, m = list(map(int, stdin.readline().split()))
s = list(stdin.readline().strip('\n').split('+'))
# n = len(a)
#k = int(stdin.readline().strip('\n'))
n = len(s)
a = []
for i in s:
    a.append(int(i))
a.sort()
for i in range(n - 1):
    print(str(a[i]), end='+')
print(a[n - 1])
