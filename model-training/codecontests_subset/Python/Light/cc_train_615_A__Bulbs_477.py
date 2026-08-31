n,m=map(int,input().split())
b=[]
for i in range(n):
    l=list(map(int,input().split()))
    for j in l[1:]:
        b.append(j)
if(len(set(b))==m):
    print("YES")
else:
    print("NO")