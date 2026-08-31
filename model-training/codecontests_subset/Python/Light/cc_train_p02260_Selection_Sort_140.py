n = int(input())
a = list(map(int, input().split()))
counter = 0
for i in range(n):
  minj = i
  for j in range(i,n):
    if a[j] < a[minj]:
      minj = j
  if i != minj:
    counter += 1
    temp = a[i]
    a[i] = a[minj]
    a[minj] = temp
print(" ".join(map(str,a)))
print(counter)
