import sys
import math
import collections
import heapq
import queue
import itertools
import functools
import operator
import time

readline = sys.stdin.readline
 
IPS = lambda: readline().rstrip()
IP = lambda: int(readline().rstrip())
MP = lambda: map(int, readline().split())
LS = lambda: list(map(int, readline().split()))

def solve():
    for _ in range(IP()):
        di = dict()
        n = IP()
        arr = LS()
        for i,elem in enumerate(arr):
            di[elem+i]=1
            
        ans = []
        for key in di.keys():
            ans.append((key%n + n)%n)
        
        ans = sorted(ans)
        fg = (len(ans)==n)
        
        if fg:
            for i in range(1,n):
                if ans[i-1]+1 != ans[i]:
                    fg = 0
                    break
            
        print("Yes") if fg else print("No")


if __name__ == "__main__":
    solve()