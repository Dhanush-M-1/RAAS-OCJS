import bisect
import collections
import copy
import functools
import heapq
import itertools
import math
import random
import re
import sys
import time
import string
from typing import *
sys.setrecursionlimit(99999)

n, k = map(int, input().split())
booksa, booksb, booksc = [], [], []
for _ in range(n):
    t, a, b = map(int, input().split())
    if a == 0 and b == 1:
        booksb.append(t)
    if a == 1 and b == 0:
        booksa.append(t)
    if a == 1 and b == 1:
        booksc.append(t)

booksa.sort()
booksb.sort()
booksc.sort()
booksa = booksa[:k]
booksb = booksb[:k]
na = len(booksa)
nb = len(booksb)
s = sum(booksa) + sum(booksb)
cj = 0
while na < k or nb < k:
    if cj == len(booksc):
        break
    s += booksc[cj]
    cj += 1
    na += 1
    nb += 1

while na > k and booksa:
    s -= booksa.pop()
    na -= 1
while nb > k and booksb:
    s -= booksb.pop()
    nb -= 1

while cj < len(booksc) and (booksa or booksb) and na >= k and nb >= k:
    sc = booksc[cj]
    cj += 1
    sa = 0
    sb = 0
    if booksa:
        sa = booksa.pop()
    if booksb:
        sb = booksb.pop()
    if sa + sb > sc:
        s += sc
        s -= sa
        s -= sb
    else:
        break

if na == k and nb == k:
    print(s)
else:
    print(-1)