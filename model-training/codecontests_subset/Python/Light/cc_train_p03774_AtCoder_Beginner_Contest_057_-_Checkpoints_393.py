a = list(map(int,input().split()))
b = [list(map(int,input().split())) for i in range(a[0])]
c = [list(map(int,input().split())) for i in range(a[1])]

for i in range(a[0]):
  d = []
  for j in range(a[1]):
    d.append(abs(b[i][0]-c[j][0])+abs(b[i][1]-c[j][1]))
  else:
    print(d.index(min(d))+1)