n,m=map(int,input().split())
l=[]
for i in range(n):
    d=list(map(int,input().split()))
    for j in d[1:]:
        l.append(j)
if(len(set(l))==m):
    print("YES")
else:
    print("NO")
