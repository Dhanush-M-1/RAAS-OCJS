
a, b, c = map(int, input().split())

if a == 0:  # line
  if b == 0:  # horizontal line
    if c == 0:  # along x axis
      print(-1)
    else:
      print(0)
  else:  # slanted line
    print(1)
    print(-c / b)

else:  # parabola
  square = b*b - 4*a*c
  if square < 0:  # complex roots
    print(0)
  elif square == 0:  # one root
    print(1)
    print(-b / (2 * a))
  else:  # two roots
    print(2)
    term = square ** 0.5
    roots = sorted([(-b + term) / (2 * a), (-b - term) / (2 * a)])
    print(roots[0])
    print(roots[1])

