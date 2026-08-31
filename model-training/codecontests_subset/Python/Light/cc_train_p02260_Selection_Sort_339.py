n=int(input())
lst=list(map(int,input().split()))
count=0
for i in range(n-1):
    minlst=min(lst[i:])
    if lst[i]==minlst:continue
    count+=1
    for j in range(i+1,n):
        if minlst==lst[j]:
            lst[i],lst[j]=lst[j],lst[i]
            break
print(*lst)
print(count)
