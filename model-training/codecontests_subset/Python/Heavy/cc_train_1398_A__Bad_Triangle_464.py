import sys
# sys.stdin = open('input.txt', 'r') 
# sys.stdout = open('output.txt', 'w')
 
import math
import collections
from sys import stdin,stdout,setrecursionlimit
import bisect as bs
setrecursionlimit(2**20)
M = 10**9+7
    
T = int(stdin.readline())
# T = 1

for _ in range(T):
    n = int(stdin.readline())
    # n,d,m = list(map(int,stdin.readline().split()))
    a = list(map(int,stdin.readline().split()))
    # q = int(stdin.readline())
    # a = list(map(int,stdin.readline().split()))
    # b = list(map(int,stdin.readline().split()))
    b = []
    for i in range(n):
        b.append((a[i],i+1))
    b.sort()
    if(b[-1][0] >= b[0][0]+b[1][0]):
        fin = [b[-1][1], b[0][1], b[1][1]]
        fin.sort()
        for h in fin:
            print(h,end=' ')
        print('')
    else:
        print(-1)