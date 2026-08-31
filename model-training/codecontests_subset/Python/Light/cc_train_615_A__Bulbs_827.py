n, m = list(map(int, input().split()))
found_ints = set()
for i in range(n):
  one_line = list(map(int, input().split()))[1:]
  for i in one_line:
     found_ints.add(i)
  if len(found_ints) == m:
     print("YES")
     exit()

print("NO")
  