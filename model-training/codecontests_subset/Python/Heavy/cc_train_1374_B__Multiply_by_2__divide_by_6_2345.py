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

for _ in range(r()):
    n=r()
    m=n
    twos=0
    while m%2==0:
        twos+=1
        m//=2
    threes=0
    while m%3==0:
        threes+=1
        m//=3
    if m!=1 or twos>threes:
        print(-1)
    else:
        cnt=twos
        threes-=twos
        cnt+=2*threes
        print(cnt)