from fractions import gcd

T = int(input())

for i in range(T):
  A, B, C, D = map(int, input().split())
  if A < B or D < B:
    print('No')
  else:
    a = A % B
    if a > C:
      print('No')
    else:
      if C >= B:
        print('Yes')
      else:
        g = gcd(B, D)
        if B - g + A%g > C:
          print('No')
        else:
          print('Yes')