x = int(input())
a = sorted(list(map(int, input().split())))
b = sorted(list(map(int, input().split())))
c = sorted(list(map(int, input().split())))
for i in range(len(b)):
  if a[i] != b[i]:
    y = a[i]
    break
  else:
    y = a[x-1]
print(y)
for i in range(len(c)):
  if b[i] != c[i]:
    z = b[i]
    break
  else:
    z = b[x-2]
print(z)