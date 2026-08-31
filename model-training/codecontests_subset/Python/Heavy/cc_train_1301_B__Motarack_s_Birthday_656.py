mod = 10**9 + 7
import math 
from bisect import bisect_left 
from collections import Counter
from itertools import combinations

def ain():
    return map(int, input().split())
def fain():
    return map(float, input().split())

def f(x,y):
    #print(x,y)
    return (x|y) - y
for _ in range(int(input())):
    n = int(input())
    ls = list(ain())
    l = []
    if ls[1] == -1 and ls[0] != -1: l.append(ls[0])
    if ls[-2] == -1 and ls[-1] != -1: l.append(ls[-1]) 
    m = 0
    if ls[0] != -1 and ls[1] != -1:
        m = max( m, abs(ls[1] - ls[0]) )
    
    for i in range(1,n-1):
        
        if ls[i] != -1 and (ls[i-1] == -1 or ls[i+1] == -1):
            l.append(ls[i])
        if ls[i] != -1 and ls[i+1] != -1:
            
            m = max( m, abs(ls[i+1] - ls[i]) )
            
    
    if len(l) > 0:
        l.sort()
        # print(l)

        maxv = max(l)
        minv = min(l)
        val = (maxv+minv)//2
        dif = max( maxv - val, val - minv )
        print(max(m, dif), val)
    else:
        print(m, 42)