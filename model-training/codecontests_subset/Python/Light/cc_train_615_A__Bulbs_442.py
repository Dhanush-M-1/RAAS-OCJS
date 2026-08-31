n,m=[int(i) for i in input().split()]
a=[]
for i in range(n):
    b=[int(j) for j in input().split()]
    for j in b[1:]:
        if j not in a:
            a.append(j)
c=0
for i in range(1,m+1):
    if i in a:
        c+=1
if c==m:
    print("YES")
else:
    print("NO")
