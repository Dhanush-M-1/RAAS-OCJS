import os
import sys
import math
import collections
#from bisect import bisect_left as bl                #c++ lowerbound bl(array,element)
#from bisect import bisect_right as br               #c++ upperbound br(array,element)
def get_int(): return int(input())
def get_ints(): return map(int, input().split())
def get_strs(): return input().split()
def get_float(): return float(input())
def get_floats(): return map(float, input().split())
def list_strs(): return list(input().split())
def list_ints(): return list(map(int, input().split()))
def list_floats(): return list(map(float, input.split()))
def post(x): print(x, end=' ')

a,b = get_ints()

res = a
mod = 0
diff = 0

while a >= b:
    diff = a//b
    res += diff
    mod = a%b
    a = diff + mod

print(res)