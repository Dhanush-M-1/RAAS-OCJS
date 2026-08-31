import sys
import math
import collections
from pprint import pprint as pp
mod = 1000000007
MAX = 10**10


def vector(size, val=0):
    vec = [val for i in range(size)]
    return vec


def matrix(rowNum, colNum, val=0):
    mat = []
    for i in range(rowNum):
        collumn = [val for j in range(colNum)]
        mat.append(collumn)
    return mat


n, x, y = map(int, input().split())
s = input()
temp = s[-x:]
ans = 0
for i in range(x):
    if i == x - y - 1:
        if temp[i] != '1':
            ans += 1
    else:
        if temp[i] == '1':
            ans += 1
print(ans)
