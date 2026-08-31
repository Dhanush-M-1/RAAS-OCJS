n=int(input())
a=[int(i) for i in input().split()]
ans=0
for i in range(n):
    m=i
    for j in range(i,n):
        if a[j]<a[m]:
            m=j
    if m!=i:
        a[i],a[m]=a[m],a[i]
        ans+=1
print(*a)
print(ans)
