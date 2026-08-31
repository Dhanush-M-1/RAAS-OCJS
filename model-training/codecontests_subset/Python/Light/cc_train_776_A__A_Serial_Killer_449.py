a, b = map(str, input().split())
n = int(input())
print("%s %s" % (a, b))
for i in range(n):
  c, d = map(str, input().split())
  a, b = ((d, b) if a == c else (a, d))
  print("%s %s" % (a, b))