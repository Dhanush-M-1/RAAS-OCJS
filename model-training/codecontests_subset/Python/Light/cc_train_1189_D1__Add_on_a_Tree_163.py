def ii():
  return int(input())
def ss():
  return [x for x in input()]
def si():
  return [int(x) for x in input().split()]
def mi():
  return map(int, input().split())

a = ii()
s = [0 for i in range(a)]
for i in range(a - 1):
  c, d = [int(x) - 1 for x in input().split()]
  s[c] += 1
  s[d] += 1
if 2 in s:
  print("NO")
else:
  print("YES")