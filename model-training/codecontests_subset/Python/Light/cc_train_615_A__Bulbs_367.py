n,m=input().split()
n,m=int(n),int(m)
l=[0]*m
for i in range(n):
    p=input().split()
    x=int(p[0])
    for j in range(x):
        l[int(p[j+1])-1]=1
if(l.count(0)==0):
    print("YES")
else:
    print("NO")