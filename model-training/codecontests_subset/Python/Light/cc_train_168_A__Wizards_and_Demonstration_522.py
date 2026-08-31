n,x,y= map(int, input() .split())
number = ((y/100) * n)
needed = number - x
if needed < 0:
  print('0')
elif number % 1 == 0:
  print (int(needed))
else:
  print(int(needed +1))