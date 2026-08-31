n, k = map(int, input().split())
a = list(map(int, input().split()))
mn = 1001
for i in range(n):
  if k % a[i] == 0:
    mn = min(mn, k / a[i])
print(int(mn))