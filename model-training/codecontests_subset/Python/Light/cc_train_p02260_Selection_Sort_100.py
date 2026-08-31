n=int(input())
c=0
a=list(map(int,input().split()))
for i in range(n):
    m=i
    for j in range(i,n):
        if a[m]>a[j]:m=j
    if i!=m:a[m],a[i]=a[i],a[m];c+=1
print(*a)
print(c)