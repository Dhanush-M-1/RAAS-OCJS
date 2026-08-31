n=int(input())
a=list(map(int,input().split(' ')))
ans=0
for i in range(0,n):
    ans=max(ans,min(abs(a[i]-1),abs(a[i]-1000000)))
print(ans)
    