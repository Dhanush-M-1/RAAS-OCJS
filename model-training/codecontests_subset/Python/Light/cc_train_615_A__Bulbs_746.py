m,n=map(int,input().split())
k=[]
for i in range(m):
    l=list(map(int,input().split()))
    k.extend(l[1:])

if(len(set(k))==n):
    print("YES")
else:
    print("NO")
