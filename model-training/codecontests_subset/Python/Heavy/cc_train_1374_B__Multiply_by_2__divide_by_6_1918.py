import math
import sys
from collections import defaultdict as df
def ini(): return int(sys.stdin.readline())
def inp(): return map(int, sys.stdin.readline().strip().split())
def li(): return list(map(int, sys.stdin.readline().strip().split()))
for i in range(ini()):
    n=ini()
    c1=0
    while(n%2==0):
        c1+=1
        n=n/2
        #print(n,c1)
    c2=0
    while(n%3==0):
        c2+=1
        n=n/3
    #print(c1,c2)
    if n!=1 or c2<c1:
        print(-1)
    else:
        print(2*c2-c1)
        
    
