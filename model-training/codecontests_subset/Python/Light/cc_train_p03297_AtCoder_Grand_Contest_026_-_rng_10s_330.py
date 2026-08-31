import fractions
T = int(input())

for i in range(T):
  a, b, c, d = map(int, input().split())

  if d<b or a<b:
    print('No')
    continue

  if b-1<=c:
    print('Yes')
    continue

  gcd=fractions.gcd(d,b)
  e=b-gcd+a%gcd
  if e>c:
    print('No')
  else:
    print('Yes')

