string = input().split(' ')

n = int(string[0])
m = int(string[1])

bulbs = []
for i in range(m):
  bulbs.append(i+1)

for i in range(n):
  string = input().split(' ')
  for j in range(int(string[0])):
    current = int(string[j+1])
    if current in bulbs:
      bulbs.remove(current)
  
if len(bulbs) == 0:
  print('YES')
else:
  print('NO')