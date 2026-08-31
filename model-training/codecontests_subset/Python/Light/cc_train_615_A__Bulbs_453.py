n,b=map(int, input().split())
res=[0]*b
for i in range(n):
    ind=list(map(int, input().split()))
    ind.pop(0)
    for j in ind:
        if res[j-1]==0:
            res[j-1]=1
if res.count(0)>=1:
    print("NO")
else:
    print("YES")
            