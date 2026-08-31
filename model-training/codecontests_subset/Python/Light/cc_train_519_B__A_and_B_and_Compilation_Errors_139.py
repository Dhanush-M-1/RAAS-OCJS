#!/usr/bin/python3

from itertools import zip_longest
input()
a = sorted(map(int, input().split()))
b = sorted(map(int, input().split()))
c = sorted(map(int, input().split()))
print([x for x, y in zip_longest(a, b) if x != y][0])
print([x for x, y in zip_longest(b, c) if x != y][0])
