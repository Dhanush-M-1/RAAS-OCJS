T = int( input() )
for t in range(T):
  m = []    
  n = int( input() )
  for i  in range(n):
    s = list( input() )
    m.append(s)
  #print(m)
  p = [ m[1][0], m[0][1], m[n-2][n-1], m[n-1][n-2] ]
  result = []
  if p[0] == p[1]:
    if p[2] == p[0]:
      result.append(2)
    if p[3] == p[0]:
      result.append(3)
  elif p[2] == p[3]:
    if p[2] == p[0]:
      result.append(0)
    if p[2] == p[1]:
      result.append(1)
  else:
    result.append(1)
    if p[2] == p[0]:
      result.append(2)
    if p[3] == p[0]:
      result.append(3)
  print( len(result) )
  for r in result:
    if r == 0:
      print("2 1")
    if r == 1:
      print("1 2")
    if r == 2:
      print(str(n-2+1) + " " + str(n-1+1))
    if r == 3:
      print(str(n-1+1) + " " + str(n-2+1))

