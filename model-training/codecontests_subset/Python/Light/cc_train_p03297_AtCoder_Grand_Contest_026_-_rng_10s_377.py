import fractions
T = int(input())
for i in range(T):
  A, B, C, D = map(int, input().split())
  if (A < B):
    print('No')
  elif (B > D):
    print('No')
  elif (C >= B):
    print('Yes')
  elif (A % B > C):
    print('No')
  elif (D % B == 0):
    print('Yes')
  else:
    gcdBD = fractions.gcd(B, D)
    if (C + gcdBD >= B):
      print('Yes')
    else:
      print('No')
