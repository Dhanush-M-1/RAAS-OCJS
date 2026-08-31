n=0
l=[]
def get(j):
    ans=0
    p=[]+l
    for i in range(n):
        if p[i]==-1:
            p[i]=j
    for i in range(n):
        if i+1<n:
            ans=max(ans,p[i]-p[i+1])
        if i-1>=0:
            ans=max(ans,p[i]-p[i-1])
    return [ans,j]
def search(l,r):
    ans=[10000000001, 10000000001]
    if r-l<10:
        for i in range(l,r+1):
            p=get(i)
            if p[0]<ans[0]:
                ans=p
        return ans
    mid=(l+r)//2
    left=get(mid-1)
    centre=get(mid)
    if left[0]<centre[0]:
        return search(l,mid-1)
    return search(mid,r)
t=int(input())
for _ in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    ans=search(0,1000000001)
    print(ans[0],ans[1])