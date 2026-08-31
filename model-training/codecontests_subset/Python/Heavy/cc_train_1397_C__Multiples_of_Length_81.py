from collections import Counter
import string
import math
import sys
# sys.setrecursionlimit(10**6) 
from fractions import Fraction
def array_int():
    return [int(i) for i in sys.stdin.readline().split()]
def vary(arrber_of_variables):
    if arrber_of_variables==1:
        return int(sys.stdin.readline())
    if arrber_of_variables>=2:
        return map(int,sys.stdin.readline().split()) 
def makedict(var):
    return dict(Counter(var))
testcases=1
for _ in range(testcases):
    n=vary(1)
    num=array_int()
    if n==1:
        print(1,1)
        print(-1*num[0])
        print(1,1)
        print(0)
        print(1,1)
        print(0)
    else:
        print(1,1)
        print(-1*num[0])
        print(1,n)
        print(0,end=" ")
        for i in range(1,n):
            print(-1*n*(num[i]),end=" ")
        print()
        print(2,n)
        for i in range(1,n):
            print((n-1)*num[i],end=" ")
        print()

