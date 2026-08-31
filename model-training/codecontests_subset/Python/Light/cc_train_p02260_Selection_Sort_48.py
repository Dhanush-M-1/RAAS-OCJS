n=int(input())
a=list(map(int,input().split()))
ans=0
for i in range(n):
  mi=i
  for j in range(i,n):
    if a[j]<a[mi]:
      mi=j
  if a[i]!=a[mi]:
    v=a[i]
    s=a[mi]
    a[i]=s
    a[mi]=v
    ans+=1
print(" ".join(map(str,a)))
print(ans)
