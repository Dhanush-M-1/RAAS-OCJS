# This code is contributed by Siddharth

from sys import *
input = stdin.readline

# from sys import *
from bisect import *
import math
from collections import *
import operator
from heapq import *
from itertools import *
inf=10**18
mod=10**9+7





# ==========================================> Code Starts Here <=====================================================================

for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    for i in range(n):
        a[i]+=i+1
        a[i]%=n
    cnt=Counter(a)
    ans=True
    for i in cnt:
        if cnt[i]>1 :
            ans=False
            break
    if ans:
        print("YES")
    else:
        print("NO")




















