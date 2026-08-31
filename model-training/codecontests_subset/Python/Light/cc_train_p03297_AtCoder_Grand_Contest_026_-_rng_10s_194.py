import fractions
N = int(input())
x = []
for i in range(N):
    a1,b1,c1,d1=[int(i) for i in input().split()]
    x.append([a1,b1,c1,d1])
for i in range(N):
  y = x[i]
  if y[0] < y[1]:
    print("No")
  elif y[1] > y[3]:
    print("No")
  elif y[1] > y[2]:
    ama = y[0] % y[1]
    mo = y[3] %  y[1]
    if mo == 0:
      if ama<= y[2]:
        print("Yes")
      else:
          print("No")
    elif mo <= y[1]-y[2]-1:
      print("No")
    else:
        to = y[1] % mo
        if to == 0:
          if ama<= y[2]:
            print("Yes")
          else:
              print("No")
        else:
          are = fractions.gcd(to, y[1])
          if are-ama%are <= y[1]-y[2]-1:
            print("No")
          else:
            print("Yes")
          
  else:
    print("Yes")