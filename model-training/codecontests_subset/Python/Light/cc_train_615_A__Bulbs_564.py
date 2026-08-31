st=[int(i) for i in input().split(" ")]
n=st[0]
m=st[1]
dif=[0]*m
f=0
for i in range(n):
    a=[int(j) for j in input().split(" ")]
    for t in range(1,len(a)):
        l=a[t]
        dif[l-1]+=1

for i in range(len(dif)):
    if dif[i]==0:
        print("NO")
        f=f+1
        break
if f==0:
    print("YES")
