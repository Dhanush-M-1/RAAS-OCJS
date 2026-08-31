n=int(input())
a=[]
for _ in range(n):
    x,h=[int(i) for i in input().split()]
    a.append([x,h])
ans=2 if n>1 else 1
for i in range(1,n-1):
    if a[i][1]<a[i][0]-a[i-1][0]:
        ans+=1
    elif a[i][1]<a[i+1][0]-a[i][0]:
        ans+=1
        a[i][0]+=a[i][1]
print(ans)
