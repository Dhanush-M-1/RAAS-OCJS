n,m=map(int,input().split())
s=set()
for i in range(n):
    l=list(map(int,input().split()))
    for j in range(1,len(l)):
        s.add(l[j])
if len(s)==m:
    print("YES")
else: print("NO")