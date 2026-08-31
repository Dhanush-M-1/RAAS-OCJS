i = int(input())

for _ in range(i):
  ii = int(input())
  lz = []
  for _ in range(ii):
    lz.append(list(input()))
  scor = [lz[0][1], lz[1][0]]
  lcor = [lz[-2][-1], lz[-1][-2]]
  zer = scor.count('0')
  zer += lcor.count('0')
  if zer == 1:
    print(1)
    if scor[0] == '0':
      print('2 1')
    elif scor[1] == '0':
      print('1 2')
    elif lcor[0] == '0':
      print(str(ii)+' '+str(ii-1))
    elif lcor[1] == '0':
      print(str(ii-1)+' '+str(ii))
  elif zer == 3:
    print(1)
    if scor[0] == '1':
      print('2 1')
    elif scor[1] == '1':
      print('1 2')
    elif lcor[0] == '1':
      print(str(ii)+' '+str(ii-1))
    elif lcor[1] == '1':
      print(str(ii-1)+' '+str(ii))
  elif zer == 2:
    if scor.count('0') == 2 or scor.count('1') == 2:
      print(0)
    else:
      print(2)
      print('1 2')
      if scor[0] == '1':
        if lcor[0] == '1':
          print(str(ii)+' '+str(ii-1))
        elif lcor[1] == '1':
          print(str(ii-1)+' '+str(ii))
      else:
        if lcor[0] == '0':
          print(str(ii)+' '+str(ii-1))
        elif lcor[1] == '0':
          print(str(ii-1)+' '+str(ii))
  else:
    print(2)
    print('1 2')
    print('2 1')