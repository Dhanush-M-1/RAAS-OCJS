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
        n = IP()
        cnt,fg = 0,0
        
        if n==1:
            print(0)
            continue
        
        while n>=6:
            if n%6==0: 
                n = int(n/6)
                fg = 0
                cnt+=1
            else:
                if fg&1: break
                else:
                    n*=2
                    fg = 1
                    cnt+=1
            
        if n==3: print(cnt+2)
        elif n==1: print(cnt)
        else: print(-1)
            
            
if __name__ == "__main__":
    solve()