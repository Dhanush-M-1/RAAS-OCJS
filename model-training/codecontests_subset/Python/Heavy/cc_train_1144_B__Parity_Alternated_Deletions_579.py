'''input
6
1 2 3 4 5 5
'''
from collections import defaultdict as dd
from collections import Counter as ccd
from itertools import  permutations as pp
from itertools import combinations as cc
from random import randint as rd
from bisect import bisect_left as bl
from bisect import bisect_right as br
import heapq as hq
from math import gcd
'''
Author : dhanyaabhirami
Hardwork beats talent if talent doesn't work hard
'''
'''
Stuck?
See github resources
Derive Formula
Kmcode blog
CP Algorithms Emaxx
'''
mod=pow(10,9) +7
def inp(flag=0):
    if flag==0:
        return list(map(int,input().strip().split(' ')))
    else:
        return int(input())

# Code credits
# assert(debug()==true)
n=inp(1)
l=inp()
odd=[]
even=[]
for i in l:
    if i%2==0:
        even.append(i)
    else:
        odd.append(i)
m=min(len(odd),len(even))
even.sort(reverse=True)
odd.sort(reverse=True)
for i in range(m):
    even[i]=0
    odd[i]=0
if len(even)==m and len(odd)>m:
    odd[m]=0
elif len(odd)==m and len(even)>m:
    even[m]=0
print(sum(even)+sum(odd))