n, m = map(int, input().split())
a = set([int(input()) for x in range(m)])

l = [0]*(n+1)
l[0] = 1

for i in range(1, n+1):
  if i in a:
    l[i] = 0
    continue
  else:
    l[i] = l[i-2] + l[i-1]

print(l[-1] % 1000000007)
