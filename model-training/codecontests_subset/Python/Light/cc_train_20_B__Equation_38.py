a, b, c = list(map(int, input().split()))

if a == 0 and b == 0 and c == 0:
  print(-1)
elif (b*b)<4*a*c:
  print(0)
elif a == 0:
  if b == 0:
    print(0)
  else:
    print(1)
    print("{0:.5f}".format(-(c/b)))
else:
  d = ((b*b) - 4*a*c)
  x1 = (-b + (d**0.5))/(2*a)
  x2 = (-b - (d**0.5))/(2*a)
  if x1 == x2:
    print(1)
    print("{0:.5f}".format(x1))
  else:
    print(2)
    print("{0:.5f}".format(min(x1, x2)))
    print("{0:.5f}".format(max(x1, x2)))
    
  
