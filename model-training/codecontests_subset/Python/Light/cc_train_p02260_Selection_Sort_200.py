n=int(input())
a=list(map(int,input().split()))
cnt=0
for i in range(n):
    mini=i
    for j in range(i,n):
        if a[mini]>a[j]:
            mini=j
    if mini!=i:
        a[i],a[mini]=a[mini],a[i]
        cnt+=1
print(*a)
print(cnt)
