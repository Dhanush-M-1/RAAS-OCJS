input()
m=list(map(int,input().split()))
ans=0
fr=10**6
for i in m:
    ans=max(ans,min(fr-i,i-1))
print(ans)