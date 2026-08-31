# Author: S Mahesh Raju
# Username: maheshraju2020
# Created on: 22/10/2020 00:46:10

from sys import stdin, stdout, setrecursionlimit
import heapq
from math import gcd, ceil, sqrt
from collections import Counter, deque
from bisect import bisect_left, bisect_right
from itertools import combinations, permutations
ii1 = lambda: int(stdin.readline().strip())
is1 = lambda: stdin.readline().strip()
iia = lambda: list(map(int, stdin.readline().strip().split()))
isa = lambda: stdin.readline().strip().split()
setrecursionlimit(100000)
mod = 1000000007

tc = ii1()
for _ in range(tc):
    n = ii1()
    arr = []
    for i in range(n):
        arr.append(is1())
    st = [[0, 1], [1, 0]]
    end = [[n - 1, n - 2], [n - 2, n - 1]]
    one, two = [], []
    for i in st:
        if arr[i[0]][i[1]] == '0':
            one.append([i[0] + 1, i[1] + 1])
        else:
            two.append([i[0] + 1, i[1] + 1])
    for i in end:
        if arr[i[0]][i[1]] == '0':
            two.append([i[0] + 1, i[1] + 1])
        else:
            one.append([i[0] + 1, i[1] + 1])
    if len(two) < 3:
        print(len(two))
        for i in two:
            print(*i)
    else:
        print(len(one))
        for i in one:
            print(*i)
    
        
        
