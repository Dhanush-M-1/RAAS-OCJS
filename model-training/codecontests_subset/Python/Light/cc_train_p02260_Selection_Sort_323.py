N=int(input())
A=list(map(int,input().split()))
cnt=0
for i in range(N):
  minj = i
  for j in range(i,N):
    if A[minj]>A[j]:
      minj = j
  _=A[minj]
  if minj != i:
    A[minj]=A[i]
    A[i]=_
    cnt+=1
print(*A)
print(cnt)
