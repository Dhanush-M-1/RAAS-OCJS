mod = 10**9 + 7
import math 
from bisect import bisect_left 
from collections import Counter
from itertools import combinations
 
def ain():
    return map(int, input().split())
def fain():
    return map(float, input().split())
 
def mc2(s):
    return (s*(s-1))//2 + s
    
for tc in range(int(input())):
    n = int(input())
    pos = True
    a = 0; b = 0
    for i in range(n):
        c,d = ain()
        if i == 0:
            if c < d:
                pos = False
        else:
       
            if c < d or c < a or d < b or (d - b > c - a):
                pos = False; 
        a,b = c,d
    if pos:
        print('YES')
    else:
        print('NO')    
# python3 pan3.py