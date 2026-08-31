n=int(input())
a=list(map(int,input().split()))
b=0
for i in range(n):
    minj=i
    for j in range(i,n):
        if a[minj]>a[j]:
            minj=j
    if i!=minj:
        a[i],a[minj]=a[minj],a[i]
        b+=1
print(*a)
print(b)
