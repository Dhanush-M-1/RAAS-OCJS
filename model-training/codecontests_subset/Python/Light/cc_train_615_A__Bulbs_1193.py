n,m=map(int,input().split())
f=True
l=[[] for i in range(n)]
for i in range(n):
    l[i]=list(map(int,input().split()))
    l[i].remove(l[i][0])
k=[]
for i in range(n):
    for j in l[i]:
        k.append(j)
for i in range(1,m+1):
    if i not in k:
        f=False
if f:
    print("YES")
else:
    print("NO")