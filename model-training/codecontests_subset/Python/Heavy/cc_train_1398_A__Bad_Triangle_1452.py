# cook your dish here
# code
#    ___________________________________
#   |                                   |
#   |                                   |
#   |        _,     _   _     ,_        |
#   |    .-'` /     \'-'/     \ `'-.    |
#   |   /    |      |   |      |    \   |
#   |  ;      \_  _/     \_  _/      ;  |
#   | |         ``         ``         | |
#   | |                               | |
#   |  ;    .-.   .-.   .-.   .-.    ;  |
#   |   \  (   '.'   \ /   '.'   )  /   |
#   |    '-.;         V         ;.-'    |
#   |        `                 `        |
#   |                                   |
#   |___________________________________|
#   |                                   |
#   |  Author      :   Ramzz            |
#   |  Created On  :   21-07-2020       |
#   |___________________________________|
#
#    _ __ __ _ _ __ ___  ________
#   | '__/ _` | '_ ` _ \|_  /_  /
#   | | | (_| | | | | | |/ / / / 
#   |_|  \__,_|_| |_| |_/___/___|
#

import math
import collections
from sys import stdin,stdout,setrecursionlimit
from bisect import bisect_left as bsl
from bisect import bisect_right as bsr
import heapq as hq
setrecursionlimit(2**20)

t = 1
t = int(stdin.readline())

for _ in range(t):
    n = int(stdin.readline())
    #s = stdin.readline().strip('\n')
    a = list(map(int, stdin.readline().rstrip().split()))
    
    s1,s2,s3=a[0],a[1],a[-1]
    
    if(a[-1]<a[0]+a[1]):
        print(-1)
    else:
        print("1 2 ",end='')
        print(n)
    
    
    