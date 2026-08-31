from fractions import gcd
T, *L = map(int, open(0).read().split())
for a,b,c,d in zip(*[iter(L)]*4):
  if b>d:
    print('No')
  elif b>a:
    print('No')
  elif c>=b:
    print('Yes')
  elif b==d:
    if a%b<c:
      print('Yes')
    else:
      print('No')
  else:
    m = d%b
    n = a%b
    g = gcd(b,d)
    if b-g+(a%g)>c:
      print('No')
    else:
      print('Yes')