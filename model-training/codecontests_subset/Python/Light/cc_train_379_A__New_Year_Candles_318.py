isDebug = False

a, b = input().split(' ')
a = int(a)
b = int(b)
print(f'a={a}, b={b}') if isDebug else ''

r = 0
u = 0
while True:
  print(f'-----\na={a}') if isDebug else ''
  r = r + a
  if a+u < b:
    break

  u = u + a

  a = int(u / b)
  u = u % b
  print(f'u={u}') if isDebug else ''

print(f'{r}')
