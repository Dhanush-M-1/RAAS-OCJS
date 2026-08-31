"""
https://codeforces.com/problemset/problem/379/A
"""

import time as t

args = [int(x) for x in input().split(" ")]
a = args[0]
b = args[1]

time = a

c = a

while c >= b:
    a = c // b
    c =( c - a*b)

    time += a
    c += a

print(time)