from queue import PriorityQueue
from queue import Queue
import math
from collections import defaultdict
import sys
import operator as op
from functools import reduce

input=sys.stdin.buffer.readline

for _ in range(int(input())):
    s= input()
    n = len(s)
    if n == 1:
        print(0)
    elif n == 2:
        if s[0] == s[1]:
            print(1)
        else:
            print(0)
    else:
        cnt = 0
        ar = [False] * n
        if s[0] == s[1]:
            ar[1] = True
            cnt += 1
        for k in range(2,n):
            if s[k] == s[k-1] and ar[k-1] == False:
                ar[k] = True
                cnt += 1
            if s[k] == s[k-2] and ar[k-2] == False:
                ar[k] = True
                cnt += 1
        print(cnt)






