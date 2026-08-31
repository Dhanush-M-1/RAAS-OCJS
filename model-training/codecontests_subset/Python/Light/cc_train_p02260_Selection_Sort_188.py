n=int(input())
count=0
a=list(map(int,input().split()))

for i in range(n):
    min=a[i]
    k=i
    for j in range((i+1),n):
        if min > a[j]:
            min=a[j]
            k=j
    if k!=i :
        a[i],a[k]=a[k],a[i]
        count+=1

print(' '.join(map(str,a)))
print(count)
