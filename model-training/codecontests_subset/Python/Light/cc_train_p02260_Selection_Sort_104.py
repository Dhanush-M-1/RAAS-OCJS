n=int(input())
l=list(map(int,input().split()))

count=0
for i in range(n):
    m=i
    for j in range(i,n):
        if l[j]<l[m]:
            m=j
    l[i],l[m]=l[m],l[i]
    if l[i]!=l[m]:
        count+=1
print(*l)
print(count)
