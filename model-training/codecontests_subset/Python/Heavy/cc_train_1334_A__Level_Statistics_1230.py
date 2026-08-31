# cook your dish here
from sys import stdin, stdout
import math
from itertools import permutations, combinations
from collections import defaultdict
from bisect import bisect_left 
 
def L():
    return list(map(int, stdin.readline().split()))
 
def In():
    return map(int, stdin.readline().split())
 
def I():
    return int(stdin.readline())
 
P = 1000000007
for t in range(I()):
    n = I()
    lis = []
    for i in range(n):
        a, b = In()
        lis.append((a, b))
        flag = 1
    (x, y) = lis[0]
    for x1, y1 in lis:
        if x1 < y1:
            flag = 0 
            break
        elif (x1 -x)< 0 or (y1 - y) < 0:
            flag = 0 
            break
        elif (x1-x) == 0:
            if (y1-y) != 0:
                flag = 0 
                break
        elif (x1-x) < (y1-y):
            flag = 0 
            break
        else:
            x = x1 
            y = y1
    if flag:
        print("YES")
    else:
        print("NO")