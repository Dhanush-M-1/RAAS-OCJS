#選択ソート
n=int(input())
a=[int(i) for i in input().split()]
k=0
for i in range(n):
    l=0
    min=i
    for j in range(n-i-1):
        if a[i+j+1]<a[min]:
            min=i+j+1
            l=1
    a[i],a[min]=a[min],a[i]
    if l==1:
        k+=1

print(" ".join(list(map(str,a))))
print(k)

