import sys
import math
import heapq
from collections import defaultdict, deque
input = sys.stdin.readline
def r():
    return int(input())
def rm():
    return map(int,input().split())
def rl():
    return list(map(int,input().split()))

'''A New Year Candles'''
a,b=rm()
cnt=a
while a//b!=0:
    cnt+=(a//b)
    a=(a//b)+(a%b)
print(cnt)
