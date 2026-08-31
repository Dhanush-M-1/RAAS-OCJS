N=int(input())
A=list(map(int,input().split()))
cnt=0
for i in range(N):
  minj = i
  for j in range(i,N):
    if A[j] < A[minj]:
      minj = j
  if i != minj:
    k=A[i]
    A[i]=A[minj]
    A[minj]=k
    cnt+=1
print(*A)
print(cnt)
