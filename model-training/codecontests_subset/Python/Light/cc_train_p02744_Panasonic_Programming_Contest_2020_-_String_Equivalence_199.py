n = int(input())
c = 'abcdefghijk'
d = [[0]]
for i in range(n-1):
  pd,d = d,[]
  for j in pd:
    m = max(j)
    for k in range(m+2):
      d.append(j+[k])
for i in d:
  for j in i[:-1]:
    print(c[j],end='')
  print(c[i[-1]])