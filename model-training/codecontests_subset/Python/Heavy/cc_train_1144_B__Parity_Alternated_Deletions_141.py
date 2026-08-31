# ///==========Libraries, Constants and Functions=============///
import sys
from bisect import bisect_left,bisect_right
from collections import deque
inf = float("inf")
mod = 1000000007
def binary(number):
    result=0
    while number:
        result=result+1
        number=number&(number-1)
    return result
def get_array(): return list(map(int, sys.stdin.readline().split()))
def get_ints(): return map(int, sys.stdin.readline().split())

sys.setrecursionlimit(1000000)
# ///==========MAIN=============///

n = int(input())
array = get_array()
array.sort()
# array.sort(reverse=True)
ret = []
balance = 0
odds = []
evens=[]
for i in array:
    if i % 2 == 0:
        evens.append(i)
    if i % 2 == 1:
        odds.append(i)
if len(odds) == len(evens):
    print(0)
else:
    if len(odds) < len(evens):
        smaller = odds
        larger = evens
    else:
        smaller = evens
        larger = odds
    for i in range(len(larger)-len(smaller)):
        ret.append(larger[i])
    ret.pop()
    print(sum(ret))
        
