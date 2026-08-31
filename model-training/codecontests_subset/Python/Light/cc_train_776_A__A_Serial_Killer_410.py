a,b=input().split()
n=int(input())
l=[]
h=[]
h.append([a,b])
for i in range(n):
  l.append(input().split())
  
for i in range(n):
  if h[i][0]==l[i][0]:
    h.append([l[i][1],h[i][1]])

  elif h[i][1]==l[i][0]:
    h.append ([h[i][0],l[i][1]])
for i in range(len(h)):
  for j in range(2):
    print(h[i][j],end=' ')
  print()