import sys
import math
import heapq
import bisect
import re
from collections import deque
from decimal import *
from fractions import gcd
 
def YES_NO(flag):
    if flag:
        print("YES")
    else:
        print("NO")
 
 
def main():
    # q = [int(i) for i in sys.stdin.readline().split()]
    n = int(sys.stdin.readline())
    q = [int(i) for i in sys.stdin.readline().split()]
    w = [0 for i in range(n + 5)]
    e = [0 for i in range(n + 5)]
    for i in range(n):
        if q[i] >= i:
            w[i] = 1
        else:
            break
    for i in range(n - 1, -1, -1):
        if q[i] >= n - i - 1:
            e[i] = 1
        else:
            break
    flag = 0
    for i in range(n):
        if w[i] and e[i]:
            flag = 1
    YES_NO(flag | w[n - 1] | e[0])
    
for i in range(int(sys.stdin.readline())):
    main()