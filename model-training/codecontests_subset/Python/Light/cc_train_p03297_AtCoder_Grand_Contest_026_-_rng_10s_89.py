def i1():
 return int(input())
def i2():
 return [int(i) for i in input().split()]
t=i1()
def gcd(a,b):
  while b:
    if a<b:
        c=b
        b=a
        a=c
    if b:a%=b
  return a
for i in range(t):
 [a,b,c,d]=i2()
 if a<b:
   print("No")
 else:
   if d<b:
      print("No")
   else:
      if c>=b:
         print("Yes")
      else:
         g=gcd(b,d)
         x=b-g+a%g
         if x>c:
           print("No")
         else:
           print("Yes")