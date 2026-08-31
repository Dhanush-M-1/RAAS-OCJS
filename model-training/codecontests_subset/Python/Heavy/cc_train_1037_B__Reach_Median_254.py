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
    n,s=vary(2)
    num=sorted(array_int())
    med=num[n//2]
    if med==s:
        print(0)
    else:
        ans=0
        # print(num)
        if med<s:
            for i in range(n//2,n):
                if s>=num[i]:
                    ans+=abs(num[i]-s)
        elif med>s:
            for i in range(n//2,-1,-1):
                if s<=num[i]:
                    ans+=abs(s-num[i])
        print(ans)
            
            