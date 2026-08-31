import os
import sys

from io import BytesIO

input = BytesIO(os.read(0, os.fstat(0).st_size)).readline

from collections import Counter

def mod(x, y):
    if x >= y:
        return x - y
    return x

n, m = map(int, input().split())
a = list(map(int, input().split()))
bb = list(map(int, input().split()))
t = Counter(a)
b = Counter(bb)
x = t[a[0]]
sdvigs = []
for el in b:
    if b[el] == x:
        sdvigs.append(el)
minshift = m
for el in sdvigs:
    shift = (el - a[0]) % m
    for el in t:
        # print(b[mod((el + shift), m)], t[el])
        if b[mod((el + shift), m)] != t[el]:
            break
    else:
        minshift = min(minshift, shift)
print(minshift)