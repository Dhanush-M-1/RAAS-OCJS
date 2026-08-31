from math import sqrt

a, b, c = map(int, input().split())

if a == 0 and b == 0:
  if c == 0:
    print(-1)
  else:
    print(0)
elif a == 0:
  print(1)
  print('{0:.10f}'.format(-(c/b)))
else:
  delta = (b**2) - (4 * a * c)

  if delta > 0:
    print(2)
    x1 = (-b + sqrt(delta)) / (2*a)
    x2 = (-b - sqrt(delta)) / (2*a)
    if x1 > x2:
      x1, x2 = x2, x1

    print('{0:.10f}'.format(x1))
    print('{0:.10f}'.format(x2))
  elif delta == 0:
    print(1)
    x1 = (-b) / (2*a)
    print('{0:.10f}'.format(x1))
  else:
    print(0)
		   			 	  		   	 	 				   	