n=int(input())
a=list(map(int,input().split()))
ans=0
for i in range(n-1):
  minj=i
  for j in range(i+1,n):
    if a[j]<a[minj]:
      minj=j
  a[i],a[minj]=a[minj],a[i]
  if minj!=i:
    ans+=1

print(*a)
print(ans)

