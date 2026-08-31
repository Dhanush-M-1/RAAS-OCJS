from fractions import*
_,*t=open(0)
for t in t:
  a,b,c,d=map(int,t.split())
  print('YNeos'[b>min(a,d)or~(~a%gcd(b,d))+b>c::2])