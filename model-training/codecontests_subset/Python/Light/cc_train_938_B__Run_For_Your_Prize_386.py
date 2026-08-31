Read = lambda: list(map(int, input().split()))

n = int(input())

t = 0
for x in Read():
   if x-1 > t and x <= 500000:
      t = x-1
   if 1000000-x > t and x > 500000:
      t = 1000000-x

print(t)