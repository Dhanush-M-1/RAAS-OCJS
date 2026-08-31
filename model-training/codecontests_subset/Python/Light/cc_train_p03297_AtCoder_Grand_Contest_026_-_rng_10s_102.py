from fractions import gcd
n=int(input())
for i in range(n):
  a,b,c,d=map(int,input().split())
  g = gcd(b,d)
  print('Yes' if (b//g-1)*g + (a % b) % g<=c and a>=b and d>=b else 'No')
