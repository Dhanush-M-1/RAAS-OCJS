n=int(input())
a=list(map(int,input().split()))
b=0
for i in range(n):
    mini=i
    for j in range(i,n):
        if a[j]<a[mini]:
            mini=j
    tmp=a[i]
    a[i]=a[mini]
    a[mini]=tmp
    if a[i]!=tmp:
        b+=1
print(" ".join(map(str,a)))
print(b)
