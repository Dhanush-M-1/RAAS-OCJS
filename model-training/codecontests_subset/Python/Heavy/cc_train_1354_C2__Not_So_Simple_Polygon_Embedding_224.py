import sys
import heapq
from math import *
import bisect

def input():
    return sys.stdin.readline().strip()
 
def iinput():
    return int(input())
 
def rinput():
    return map(int, input().split())

def rlinput():
    return list(map(int, input().split()))

def srlinput(fl=False):
    return sorted(list(map(int, input().split())) , reverse=fl)


def main():
    n = iinput()
    #n, k = rinput()
    #n, m, k = rinput()
    t = cos(pi * (n - 1) / (2 * n))
    print(((1 - t) ** 0.5 + (1 + t) ** 0.5) / (2 * sin(pi / (2 * n))))

    
    
    
        
    
            
for sdfghjkl in range(iinput()):
    main()