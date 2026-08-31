n,m=map(int,input().split())
s=set()
for _ in range(n):
    l=list(map(int,input().split()))
    x=len(l)
    for i in range(1,x):
        s.add(l[i])
if(len(s)==m):
    print("YES")
else:
    print("NO")