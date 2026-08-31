n=int(input())
A=list(map(int,input().split()))
ans=0

for i in range(n):
  minj=i
  for j in range(i+1,n):
    if A[j]<A[minj]:
      minj=j
  if i==minj: continue
  tmp=A[i]
  A[i]=A[minj]
  A[minj]=tmp
  ans+=1
print(*A)
print(ans)

