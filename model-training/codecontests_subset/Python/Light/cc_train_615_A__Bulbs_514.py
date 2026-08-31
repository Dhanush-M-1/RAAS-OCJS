n,m=map(int,input().split())
l=[0]*(m+1)
for _ in range(n):
    x=list(map(int,input().split()))
    for i in range(1,len(x)):
        l[x[i]]=1
if(sum(l)==m):
    print("YES")
else:
    print("NO")