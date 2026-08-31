import sys
from io import BytesIO, IOBase
from collections import defaultdict, deque, Counter, OrderedDict
import threading
from heapq import *
from math import gcd


def main():
    n = int(input())
    D = []
    for i in range(n):
        x = bin(int(input(), 16))[2:]
        D.append('0' * (n - len(x)) + x)

    row = []
    length = 1
    for i in range(1, n):
        if D[i - 1] == D[i]:
            length += 1
        else:
            row.append(length);length = 1
    row.append(length)

    col = []
    length = 1
    for i in range(1, n):
        flag = True
        for j in range(n):
            if D[j][i - 1] != D[j][i]: flag = False
        if flag:
            length += 1
        else:
            col.append(length);length = 1
    col.append(length)

    ans1 = row[0]
    for x in row:
        ans1 = gcd(ans1, x)
    ans2 = col[0]
    for y in col:
        ans2 = gcd(ans2, y)
    print(gcd(ans1, ans2))
main()