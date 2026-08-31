import sys
sys.setrecursionlimit(10**9)
t=int(input())

def dfs(s,d):
    if len(s)==0:
        return
    if len(s)==0:
        nums[s[0]]=d
        return
    m=max(s)
    nums[m]=d
    b=[]
    for i in s:
        if i==m:
            dfs(b,d+1)
            b=[]
        else:
            b.append(i)
    if len(b)>0:
        dfs(b,d+1)

for _ in range(t):
    n=int(input())
    a=list(map(int, input().split()))
    ans=[-1 for i in range(n)]
    nums=[-1 for i in range(n+1)]
    dfs(a,0)
    for i in range(n):
        x=nums[a[i]]
        ans[i]=x
    print(*ans)
