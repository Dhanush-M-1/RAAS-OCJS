n,m = map(int,input().split(' '))
bulb = [bool(False) for i in range(int(1e2+5))]

for i in range(n):
  arr = [int(i) for i in input().split(' ')]
  for j in range(1,len(arr)):
    bulb[arr[j]] = True

for i in range(1,m+1):
  if(not bulb[i]):
    print('NO')
    break
else:
  print('YES')

