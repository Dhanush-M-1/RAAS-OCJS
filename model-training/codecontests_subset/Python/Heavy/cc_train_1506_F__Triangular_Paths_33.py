import sys
input = sys.stdin.readline
from collections import *

for _ in range(int(input())):
    n = int(input())
    r = list(map(int, input().split()))
    c = list(map(int, input().split()))
    rc = [(ri, ci) for ri, ci in zip(r, c)]
    rc.sort()
    plevel = 0
    pr = 1
    pc = 1
    ans = 0
    
    for r, c in rc:
        level = (r-c)//2
        ans += level-plevel
        
        if level==plevel and (pr-pc)%2==0 and (r-c)%2==0:
            ans += r-pr
            
        plevel = level
        pr = r
        pc = c
        
    print(ans)