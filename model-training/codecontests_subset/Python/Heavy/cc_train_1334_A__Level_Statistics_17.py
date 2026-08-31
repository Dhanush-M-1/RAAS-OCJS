import sys
input = sys.stdin.readline
from collections import *

T = int(input())

for _ in range(T):
    n = int(input())
    pp, pc = 0, 0
    flag = True
    
    for _ in range(n):
        p, c = map(int, input().split())
        
        if p==pp:
            if c>pc or c<pc:
                flag = False
        elif p<pp:
            flag = False
        else:
            if c<pc:
                flag = False
                
            if c-pc>p-pp:
                flag = False
        
        pp, pc = p, c
    
    if flag:
        print('YES')
    else:
        print('NO')