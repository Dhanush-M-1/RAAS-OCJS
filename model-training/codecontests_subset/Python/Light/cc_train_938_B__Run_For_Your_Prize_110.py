n = int(input())
v = map(int, input().split())
maxi = 0
for x in v:
  maxi = max(maxi, min(1000000 - x, x - 1))
print(maxi)