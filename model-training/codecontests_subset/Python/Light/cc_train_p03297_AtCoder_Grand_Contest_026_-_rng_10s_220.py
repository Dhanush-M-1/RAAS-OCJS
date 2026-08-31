def gcd(a, b):
  while b:
    a, b = b, a % b
  return a
for _ in range(int(input())):
  a,b,c,d=map(int,input().split())
  if a<b or b>d:print("No");continue
  if c>=b:print("Yes");continue
  g=gcd(b,d)
  if (a%g+b-g)%b>c:print("No")
  else:print("Yes")