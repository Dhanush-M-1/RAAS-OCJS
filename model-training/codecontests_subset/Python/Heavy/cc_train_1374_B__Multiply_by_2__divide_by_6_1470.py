import sys
RI = lambda : [int(x) for x in sys.stdin.readline().strip().split()]
from collections import defaultdict as df
import copy
import math
#from queue import PriorityQueue as pq
t = int(input().strip())
for _ in range(t):
    n = int(input().strip())
    two = 0
    three = 0
    while(n%2==0):
        n//=2
        two+=1
    
    while(n%3==0):
        n//=3
        three+=1
    
    if(n!=1):
        print("-1")
    elif(two>three):
        print("-1")
    elif(two==three):
        print(two)
    else:
        print(three-two  + three)
