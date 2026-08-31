# cook your dish here
#code
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
    #n = int(stdin.readline())
    #s = str(stdin.readline().strip('\n'))
    n,m = list(map(int, stdin.readline().rstrip().split()))
    a = list(map(int, stdin.readline().rstrip().split()))
    b = list(map(int, stdin.readline().rstrip().split()))
    
    d1 = {}
    d2 = {}
    for i in a:
        d1[i] = True
    b.sort()
    chk = False
    for j in b:
        if(j in d1):
            ans = j
            chk = True
            break
    if(chk):
        print('YES')
        print(1,ans)
    else:
        print('NO')
    
    
    
    
    
    
    