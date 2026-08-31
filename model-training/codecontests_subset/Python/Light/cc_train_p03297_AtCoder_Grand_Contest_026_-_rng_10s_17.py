T = int(input())
ABCD = [list(map(int, input().split())) for _ in range(T)]

from fractions import gcd

for a,b,c,d in ABCD:
  if a<b:
    print('No')
    continue
    
  l = gcd(b,d)
  a = a % b
  if (a + ((b-a-1)//l)*l) <= c and (a - (a//l)*l)+d>=b:
    print('Yes')
  else:
    print('No')

    