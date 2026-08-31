l=[]
for i in range(int(input())):
  l.append(list(map(int,input().split())))
z=[]
d=0
for i in range(len(l)-1):
  z.append(abs(l[i][0]-l[i+1][0]))
  if i>0:
    if l[i][1]<z[i-1]:
      d+=1
      z[i-1]=abs(l[i][1]-z[i-1])
    elif l[i][1]<z[i]:
      d+=1
      z[i]=abs(l[i][1]-z[i])
if len(l)>2:
  print(d+2)
else:
  print(len(l))