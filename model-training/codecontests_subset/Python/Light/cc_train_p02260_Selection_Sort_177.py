n=int(input())
A=[int(i) for i in input().split()]

count=0

for i in range(0,n,1):
  minj=i
  for j in range(i+1,n,1):
    if A[minj] > A[j]:
      minj=j
  if i != minj:
    a= A[i]
    A[i]=A[minj]
    A[minj]=a
    count+=1
  
print(*A, sep=' ')
print(count)
