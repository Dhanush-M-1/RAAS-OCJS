n,m=map(int,input().split())
l=[]
for i in range(0,n):
    a=list(map(int,input().split()))
    for i in a[1:]:
        l.append(i)
l=set(list(l))
if len(l)==m:
    print("YES")
else:
    print("NO")
    