a, b = map(int, input().split())
count = 0
i = 1
while i*b <= a:
  i += 1
  a += 1
while a > 0:
  count += 1
  a -= 1
print(count)