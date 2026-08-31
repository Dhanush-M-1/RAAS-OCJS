n, a, b, c = map(int, input().split())
count = 0
for ci in range(c + 1):
  x = n - 2 * ci
  if x < 0:
    break
  high = min(b, x)
  low = max(0, x - a // 2)
  if high >= low:
    count += high - low + 1

print(count)




# Made By Mostafa_Khaled