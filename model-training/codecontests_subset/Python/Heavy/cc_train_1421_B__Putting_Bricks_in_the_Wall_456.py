import math,sys
from sys import stdin,stdout
from collections import Counter, defaultdict, deque
input = stdin.readline
I = lambda:int(input())
li = lambda:list(map(int,input().split()))

def solve():
    n=I()
    a=[]
    for i in range(n):
        a.append(input().strip())
    p=a[0][1]
    q=a[1][0]
    r=a[n-1][n-2]
    s=a[n-2][n-1]
    ans=[]
    if(p=='0' and q=='0'):
        if(r=='0'):
            ans.append([n,n-1])
        if(s=='0'):
            ans.append([n-1,n])
    elif(p=='1' and q=='1'):
        if(r=='1'):
            ans.append([n,n-1])
        if(s=='1'):
            ans.append([n-1,n])
    elif(r=='0' and s=='0'):
        if(p=='0'):
            ans.append([1,2])
        if(q=='0'):
            ans.append([2,1])
    elif(r=='1' and s=='1'):
        if(p=='1'):
            ans.append([1,2])
        if(q=='1'):
            ans.append([2,1])
    else:
        if(p=='1'):
            ans.append([1,2])
        if(q=='1'):
            ans.append([2,1])
        if(r=='0'):
            ans.append([n,n-1])
        if(s=='0'):
            ans.append([n-1,n])
    print(len(ans))
    for i in ans:
        print(*i)
                
for _ in range(I()):
    solve()