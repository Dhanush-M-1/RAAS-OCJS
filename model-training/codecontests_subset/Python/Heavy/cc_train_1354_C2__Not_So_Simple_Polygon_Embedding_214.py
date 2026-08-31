import sys, math,os
from io import BytesIO, IOBase
from bisect import bisect_left as bl, bisect_right as br, insort
#from heapq import heapify, heappush, heappop
from collections import defaultdict as dd, deque, Counter
#from itertools import permutations,combinations
def data(): return sys.stdin.readline().strip()
def mdata(): return list(map(int, data().split()))
def outl(var) : sys.stdout.write(' '.join(map(str, var))+'\n')
def out(var) : sys.stdout.write(str(var)+'\n')
sys.setrecursionlimit(100000)
INF = float('inf')
mod = int(1e9)+7

def main():

    for t in range(int(data())):
        n=int(data())
        print(max((0.5/math.sin(((90/n)*math.pi)/180)/math.sin(((45)*math.pi)/180)*math.sin(((180-45-(180/n)*(n//4+1))*math.pi)/180))*(2**0.5),(0.5/math.sin(((90/n)*math.pi)/180)/math.sin(((45)*math.pi)/180)*math.sin(((180-45-(180/n)*(n//4))*math.pi)/180))*(2**0.5)))

if __name__ == '__main__':
    main()