a=input().split()
n=int(a[0])
m=int(a[1])
l=[list(map(int,input().split())) for i in range(n)]
l2=[]
for i in range(n):
    l2+=l[i][1:]

if len(set(l2))==m:
    print("YES")
else:
    print("NO")