# cook your dish here
from sys import stdin,stdout
from collections import Counter
from itertools import permutations
import bisect
import math
I=lambda: map(int,stdin.readline().split())
I1=lambda: stdin.readline()

for _ in range(int(I1())):
    n=int(I1())
    l=list(I())
    x,y,z=l[0],l[1],l[n-1]
    if(x+y>z): print(-1)
    else: print(1,2,n)
    