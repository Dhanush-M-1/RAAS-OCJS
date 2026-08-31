n= int(input())
a = sorted([int(i) for i in input().split()])
b = sorted([int(i) for i in input().split()])
c = sorted([int(i) for i in input().split()])
found = False
for i in range(len(b)):
  if b[i] != a[i]:
    found= True
    print(a[i])
    break

if not(found):
  print(a[-1])

found = False
for i in range(len(c)):
  if c[i] != b[i]:
    found= True
    print(b[i])
    break

if not(found):
  print(b[-1])