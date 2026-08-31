import math
from bisect import bisect_left,bisect,bisect_right
from itertools import accumulate

def index(a, x):
    'Locate the leftmost value exactly equal to x'
    i = bisect_left(a, x)
    if i != len(a) and a[i] == x:
        return i
    raise ValueError

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

def func(n,x,y):
    return max(0,math.ceil(y*n/100)-x)











for _ in range(1):#int(input())):
    n,a,b=map(int,input().split())
    #n = int(input())
    #inp=input().split()
    #s=input()
    #l1=[]
    #l1=list(map(int,input().split()))
    #l1=list(accumulate(list(map(int,input().split()))))
    #q=int(input())
    #l2 = list(map(int, input().split()))
    #l1=input().split()
    #l2=input().split()
    #func(n,m)
    st+=str(int(func(n,a,b)))+'\n'
print(st)