tmp = list(map(int, input().split()))
n = tmp[0]
m = tmp[1]

s = [1] * (n+1)
for i in range(m):
  m = int(input())
  s[m] = 0

for i in range(2, n+1):
  if s[i] != 0:
    s[i] = s[i-1] + s[i-2]

print(s[n] % 1000000007)