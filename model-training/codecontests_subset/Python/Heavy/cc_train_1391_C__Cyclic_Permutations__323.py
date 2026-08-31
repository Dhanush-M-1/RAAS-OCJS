import sys
# sys.stdin = open('input.txt', 'r') 
# sys.stdout = open('output.txt', 'w')
 
import math
import collections
from sys import stdin,stdout,setrecursionlimit
import bisect as bs
setrecursionlimit(2**20)
MOD = 10**9+7
    
# T = int(stdin.readline())
T = 1

for _ in range(T):
    n = int(stdin.readline())
    # n,k,Z = list(map(int,stdin.readline().split()))
    # a = [-1]+list(map(int,stdin.readline().split()))
    # q = int(stdin.readline())
    # b = list(map(int,stdin.readline().split()))
    # q = list(map(int,stdin.readline().split()))
    # b = list(map(int,stdin.readline().split()))
    fac = 1
    for i in range(1,n+1):
        fac = (fac*i)%MOD
    p2 = pow(2,n-1,MOD)
    print((fac-p2)%MOD)