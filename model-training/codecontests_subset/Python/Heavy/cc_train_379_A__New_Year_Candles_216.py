from collections import deque
from collections import OrderedDict
import math
 
import sys
import os
import threading
import bisect

import operator
 
import heapq


from atexit import register
from io import BytesIO

#sys.stdin = BytesIO(os.read(0, os.fstat(0).st_size))
#sys.stdout = BytesIO()
#register(lambda: os.write(1, sys.stdout.getvalue()))


import io
#input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
#sys.stdin = open("F:\PY\\test.txt", "r")
input = lambda: sys.stdin.readline().rstrip("\r\n")
#input = sys.stdin.readline

 
 
n, m = map(int, input().split())
answer = n
rem = 0
while(n+rem>=m):
    temp = (n+rem)
    n=(n+rem)//m
    rem = temp%m
    answer+=n
print(answer)