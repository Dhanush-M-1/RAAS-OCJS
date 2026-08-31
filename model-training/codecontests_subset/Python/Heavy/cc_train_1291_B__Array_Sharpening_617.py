from collections import deque
from math import ceil,floor,sqrt,gcd
def ii(): return int(input())
def mi(): return map(int,input().split())
def li(): return list(mi())
def si():return input()
t=1
t=ii()
while(t):
    t-=1
    n=ii()
    a=li()
    if(n==1):
        print('Yes')
        continue
    if(n==2):
        if(a[1]>a[0] or a[1]<a[0]):
            print('Yes')
        else:
            if(a[1]>0):
                print('Yes')
            else:
                print('No')
        continue
    f1=0
    f=0
    a[0]=0
    a1=a[:]
    for i in range(1,n):
        if(a[i]<=a[i-1]):
            f=i
            break
        else:
            a[i]=a[i-1]+1
    if(f):
        a[f-1]=max(a[f-1],a1[f-1])
        for j in range(f,n):
            if(a[j]>=a[j-1]):
                a[j]=a[j-1]-1
                if(a[j]<0):
                    f1=1
                    break
        if(f1):
            print('No')
        else:
            print('Yes')
    else:
        print('Yes')
    