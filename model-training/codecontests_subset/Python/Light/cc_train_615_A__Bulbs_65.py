m, n = map(int, input().split())
bulbs = [0]*n
for i in range(m):
  switch = list(map(int,input().split()))
  for i in range(switch[0]):
    bulbs[switch[i+1]-1] =  1
if 0 in bulbs:
  print("NO")
else:
  print("YES")