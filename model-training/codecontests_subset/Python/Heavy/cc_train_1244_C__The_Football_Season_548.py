def exgcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        g, x, y = exgcd(b % a, a)
        return (g, y - (b // a) * x, x)

n, p, w, d = map(int, input().split())
if p == 0:
  print(0,0,n)
else:
  g, x, y = exgcd(d, w)
  if(p % g != 0):
    print(-1)
  else:
    b1 = w // g
    x1 = (x + b1) * (p // g)
    x1 = (x1 % b1 + b1) % b1
    y1 = (p - d * x1) // w
    if((y1 < 0) or (x1 < 0)):
      print(-1)
    elif(y1+x1 <= n):
      print(y1,x1,n-x1-y1)
    else:
      print(-1)

