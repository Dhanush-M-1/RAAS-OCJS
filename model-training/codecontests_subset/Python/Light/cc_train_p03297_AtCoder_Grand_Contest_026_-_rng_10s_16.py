def gcd(a, b):
  while b > 0:
    a, b = b, a % b
  return a

T = int(input())
for _ in range(T):
  A, B, C, D = map(int, input().split())
  if B > D or B > A:
    print('No')
    continue
  if C >= B - 1:
    print('Yes')
    continue
  a = A % B
  step = gcd(B, D)
  k = (B - a + step - 1) // step - 1
  if C - a < k * step:
    print('No')
  else:
    print('Yes')