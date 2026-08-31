import math 
from itertools import combinations
from collections import Counter 

t = int(input())
for _ in range(t):
    n = int(input())
    # a,b = map(int, input().split())
    a = list(map(int, input().split()))
    f = 0
    x = [1,2]
    
    for i in range(2,len(a)):
        if a[x[0]-1] + a[x[1]-1] <= a[i]:
            x.append(i+1)
            f = 1
            break
    if f:
        for i in sorted(x):
            print(i,end=" ")
        print()
    else:
        print(-1)
