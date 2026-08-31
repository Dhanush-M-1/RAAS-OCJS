n=int(input())
l=[]
for i in range(n):
  a,b=[int(x) for x in input().split()]
  l.append((a,b))
no=2
pre=l[0][0]
for i in range(1,n-1):
  n1=l[i]
  n2=l[i+1]
  if n1[0]-pre>n1[1]:
    no=no+1
    pre=n1[0]
    continue
  if n1[0]+n1[1]<n2[0]:
    no=no+1
    pre=n1[0]+n1[1]
    continue
  pre=n1[0]
if n==1:
  print(1)
else:
  print(no)
