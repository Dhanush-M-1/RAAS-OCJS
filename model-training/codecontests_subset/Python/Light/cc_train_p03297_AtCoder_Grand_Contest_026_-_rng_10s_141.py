from fractions import gcd
T,*L = map(int, open(0).read().split())
for a,b,c,d in zip(*[iter(L)]*4):
  if b>d:
    print('No')
    continue
  if a<b:
    print('No')
    continue
  g = gcd(b,d)
  x = a-b
  M = ((c-x)//g+1)*g+x
  if M>=b:
    print('Yes')
  else:
    print('No')