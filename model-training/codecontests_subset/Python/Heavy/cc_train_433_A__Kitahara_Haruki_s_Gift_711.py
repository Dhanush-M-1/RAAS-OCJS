import math
from bisect import bisect_left,bisect,bisect_right
from itertools import accumulate

def index(a, x):
    'Locate the leftmost value exactly equal to x'
    i = bisect_left(a, x)
    if i != len(a) and a[i] == x:
        return i
    return -1#that is,DNE

def find_lt(a, x):
    'Find rightmost value less than x'
    i = bisect_left(a, x)
    if i:
        return a[i-1]
    raise ValueError

def find_le(a, x):
    'Find rightmost value less than or equal to x'
    i = bisect_right(a, x)
    if i:
        return a[i-1]
    raise ValueError

def find_gt(a, x):
    'Find leftmost value greater than x'
    i = bisect_right(a, x)
    if i != len(a):
        return a[i]
    raise ValueError

def find_ge(a, x):
    'Find leftmost item greater than or equal to x'
    i = bisect_left(a, x)
    if i != len(a):
        return a[i]
    raise ValueError

st=''
def func(n,l1):
    l1.sort()
    one=l1.count(100)
    two=n-one
    #print(one,two)
    if one&1:
        return 'NO'
    if one%2==0 and two%2==0:
        return 'YES'
    if two%2 and(one>1):
        return 'YES'
    return 'NO'













#a,b=map(int,input().split())
n = int(input())
#inp=input().split()
#s=input()
l1=list(map(int,input().split()))
#l1=list(accumulate(list(map(int,input().split()))))
#q=int(input())
#l2 = list(map(int, input().split()))
#l1=input().split()
#l2=input().split()
#func(n,l1)
#st+=str((func(a,b)))+'\n'
print(func(n,l1))