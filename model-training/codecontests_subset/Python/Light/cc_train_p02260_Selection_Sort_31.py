n = int(input())
a = list(map(int, input().split()))

ans = 0
for i in range(n - 1):
  minj = i
  for j in range(i, n):
    if a[j] < a[minj]:
      minj = j
  if i != minj:
    a[minj], a[i] = a[i], a[minj]
    ans += 1

print(" ".join(map(str, a)))
print(ans)
