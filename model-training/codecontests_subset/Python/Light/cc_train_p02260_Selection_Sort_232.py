cou = 0

N = int(input())
l = list(map(int, input().split()))

for i in range(N):
  minj = i
  for j in range(i,N):
    if l[j] < l[minj]:
      minj = j
  if not l[i] == l[minj]:
    a = l[i]
    b = l[minj]
    l[i] = b
    l[minj] = a
    cou += 1

print(" ".join(map(str,l)))
print(cou)

