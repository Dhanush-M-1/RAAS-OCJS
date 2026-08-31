
from sys import stdin
input=stdin.buffer.readline
import math

def func(dp,start,end,x):
    pos=-1
    while start<=end:
        mid=(start+end)//2
        if dp[mid][0]>=x:
            pos=mid
            end=mid-1
        else:
            start=mid+1
    return pos            


t=int(input())
for i in range(t):
    n,m=map(int,input().split())
    arr=[int(x) for x in input().split()]
    query=[int(x) for x in input().split()]

    x=0
    dp=[]
    for i in range(n):
        x=x+arr[i]
        dp.append((x,i))
    s=x
    dp.sort()
    stack=[-1]*n
    mn=1000000
    
    # print(dp)
    for i in range(n-1,-1,-1):
        mn=min(mn,dp[i][1])
        stack[i]=mn
    # print(stack)

    ans=[]
    for q in query:
        if dp[-1][0]<=0:
            ans.append(-1)
            continue

        if q<=dp[-1][0]:
            x=func(dp,0,n-1,q)
            ans.append(stack[x])
            continue

        if s<=0:
            ans.append(-1)
            continue

        c=math.ceil((q-dp[-1][0])/s)
        new_ans=c*n
        q=q-c*s
        x=func(dp,0,n-1,q)
        ans.append(new_ans+stack[x])

    print(*ans)