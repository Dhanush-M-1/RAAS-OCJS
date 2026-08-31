a, b = input().split()
n = int(input())
print(a, b)
for i in range(n):
  x, y = input().split()
  if a==x:
    a = y
  elif a==y:
    a = x
  elif b==x:
    b=y
  elif b==y:
    b=x
  print(a, b)