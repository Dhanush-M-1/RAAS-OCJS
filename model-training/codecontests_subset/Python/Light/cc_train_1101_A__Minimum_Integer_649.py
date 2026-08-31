n = int(input())

def func(a, b, d):
  if a>d:
    return d
  else:
    if b%d==0:
      return b+d
    else:
      return (b//d)*d+d

for i in range(n):
  s = input().split()
  print(func(int(s[0]), int(s[1]), int(s[2])))