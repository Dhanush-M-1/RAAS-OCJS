tests = int(input())
ans = [None] * tests

for i in range(tests):
  x, y, z = map(int, input().split())

  if (z < x or z > y):
    ans[i] = z
  else:
    ans[i] = (y // z) * z+z
for sol in ans: 
  print(sol)