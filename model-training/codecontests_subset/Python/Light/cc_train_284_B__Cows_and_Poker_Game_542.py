n = int(input())
s = input()
count = {}
for x in s:
  count[x] = count.get(x, 0) + 1
ans = 0
for x in s:
  if x in 'AI':
    count[x] -= 1
    if count.get('I', 0) == 0:
      ans += 1
    count[x] += 1
print(ans)