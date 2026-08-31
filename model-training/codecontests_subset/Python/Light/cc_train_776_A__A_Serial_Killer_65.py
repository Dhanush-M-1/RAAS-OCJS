f, s = input().split()
print(f, s)
n = int(input())

for _ in range(n):
  killed, new = input().split()
  if killed == f:
    f = new
    print(f, s)
  else:
    s = new
    print(f, s)
