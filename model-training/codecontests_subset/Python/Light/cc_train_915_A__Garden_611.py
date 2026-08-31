n,m=map(int,input().split())
l=list(map(int,input().split()))
ans=[]
for i in range(n):
    if m%l[i]==0:
        ans.append(m//l[i])
print(min(ans))