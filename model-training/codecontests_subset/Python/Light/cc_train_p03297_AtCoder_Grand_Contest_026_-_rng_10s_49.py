from fractions import gcd
from functools import reduce
def gcds(*numbers):
  return reduce(gcd, numbers)
n = int(input())
for i in range(n):
  a,b,c,d = map(int,input().split())
  x = gcds(a,b,c,d)
  if x != 1:
    a = a//x
    b = b//x
    c = c//x
    d = d//x
  if b>d or a<b:
    print("No")
  elif c>=b-1:
    print("Yes")
  elif gcd(b,d) != 1:
    y = gcd(b,d)
    if b-c<y and c%y >= a%y:
        print("Yes")
    else:
      print("No")
  else:
    print("No")
