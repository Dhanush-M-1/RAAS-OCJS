from math import *
from sys import *
t=int(stdin.readline())
for _ in range(t):
    n=int(stdin.readline())
    m = []
    ans=[]
    for i in range(n):
        a = list(input())
        m.append(a)
    x=m[0][1]
    a=0
    f=0
    if m[n-1][n-2]==x and m[n-2][n-1]==x:
        a+=1
        ans.append([1,2])
        if x==0:
            m[0][1]=1
        else:
            m[0][1]=0
    elif m[n-1][n-2]==x and m[n-2][n-1]!=x:
        a+=1
        ans.append([n,n-1])
        f=1
    elif m[n-1][n-2]!=x and m[n-2][n-1]==x:
        a+=1
        ans.append([n-1,n])
        f=1
    if m[1][0]!=m[0][1]:
        if f==1:
            ans.append([2,1])
            a+=1
        else:
            if m[1][0]==m[n-1][n-2]:
                ans.append([2,1])
                a += 1

    print(a)
    for i in range(a):
        print(*ans[i])
