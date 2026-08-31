import sys
input=sys.stdin.readline
n=int(input())
s=list(map(int,input().split()))
BIT=[0]*(n+1)
def update(i,w):
    while i<=n:
        BIT[i]+=w
        i+=(i&-i)
def get_sum(i):
    res=0
    while i>0:
        res+=BIT[i]
        i-=(i&-i)
    return res
for i in range(1,n+1):
    update(i,i)
ans=[-1]*n
for i in range(n)[::-1]:
    l=0;r=n
    ss=s[i]
    while True:
        mid=(l+r+1)//2
        if get_sum(mid)>ss:
            if get_sum(mid-1)==ss:
                ans[i]=mid
                break
            else:
                r=mid
        else:
            l=mid
    update(mid,-mid)
print(*ans)