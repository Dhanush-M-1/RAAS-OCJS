n=int(input())
A=list(map(int,input().split()))
count = 0
for i in range(n):
  minj = i
  for j in range(i,n):
    if A[j] < A[minj]:
      minj = j
  if i != minj:
    A[i], A[minj]=A[minj],A[i]
    count += 1
a=map(str,A)
print(" ".join(a))
print(count)
