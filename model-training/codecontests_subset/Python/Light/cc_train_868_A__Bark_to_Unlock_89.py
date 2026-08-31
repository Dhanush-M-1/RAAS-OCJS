c=input()
n=int(input())
l=[]
f=0
for i in range(n):
  l.append(input())
for i in l:
  for j in l:
    if c in i+j:
      f=1
      break
if f==1:
  print('YES')
else:
  print('NO')