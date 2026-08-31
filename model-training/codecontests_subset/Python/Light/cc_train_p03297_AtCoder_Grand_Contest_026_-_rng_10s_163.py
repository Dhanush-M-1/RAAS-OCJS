from fractions import*
_,*t=open(0)
for t in t:
  a,b,c,d=map(int,t.split())
  g=gcd(b,d)
  print('YNeos'[b>min(a,d)or b-g+a%g>c::2])