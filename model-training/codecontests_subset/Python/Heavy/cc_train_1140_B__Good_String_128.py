'''input
3
2
<>
3
><<
1
>
'''
import sys
from collections import defaultdict as dd
from itertools import  permutations as pp
from itertools import combinations as cc
from collections import Counter as ccd
from random import randint as rd
from bisect import bisect_left as bl
import heapq
mod=10**9+7

def ri(flag=0):
	if flag==0:
		return [int(i) for i in sys.stdin.readline().split()]
	else:
		return int(sys.stdin.readline())

for i in range(ri(1)):
    n=ri(1)
    a=input()
    one=0
    two=0
    i=0
    while (i<n):
    	if a[i]=="<":
    		one+=1
    	else:
    		break
    	i+=1
    i=n-1
    while (i>-1):
    	if a[i]==">":
    		two+=1
    	else:
    		break
    	i-=1

    print(min(one,two))