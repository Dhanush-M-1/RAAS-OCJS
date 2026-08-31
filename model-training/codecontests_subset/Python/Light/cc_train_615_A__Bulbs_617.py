x=[int(i) for i in input().split(' ')]
m=[i+1 for i in range(x[1])]
for i in range(x[0]):
  line =[int(i) for i in input().split(' ')]
  h=line[0]
  line = line[1:]
  for j in line:
    if j in m:
      m.remove(j)
print('NO') if m else print('YES')