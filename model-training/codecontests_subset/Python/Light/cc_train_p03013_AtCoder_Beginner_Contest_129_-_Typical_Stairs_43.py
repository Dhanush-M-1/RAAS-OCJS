mod = 10**9+7
n, m = map(int, input().split())
l = [0]*n
for _ in range(m):
  l[int(input())-1] = 1

s = 0
t = 1

for i in range(n):
  if l[i] > 0:
    t, s = 0, t
  else:
    t, s = (s+t)%mod, t

print(t)