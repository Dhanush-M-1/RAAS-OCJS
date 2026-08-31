from decimal import Decimal
import sys
for l in sys.stdin:
  xa,ya,xb,yb,xc,yc,xd,yd=list(map(Decimal,l.split(",")))
  a=xd-xb
  b=yd-yb
  c=xa-xb
  d=ya-yb
  e=xc-xb
  f=yc-yb
  try:
    s=(a*f-b*e)/(c*f-d*e)
    t=(-a*d+b*c)/(c*f-d*e)
  except:
    print("NO")
  if s>=0 and t>=0 and s+t>=1:
    print("YES")
  else:
    print("NO")
