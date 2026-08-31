ans = input().split()
n = int(input())
print(*ans)
for _ in range(n):
  names = input().split()
  for i in range(2):
    if ans[i] == names[0]:
      ans[i] = names[1]
  print(*ans)