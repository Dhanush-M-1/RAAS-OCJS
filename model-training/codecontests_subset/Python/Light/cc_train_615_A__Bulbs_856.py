import sys
nums=input()
l= nums.split()
n=int(l[0])
m=int(l[1])
s=[]
r=1
for z in range (m):
  s.append(0)
for j in range(n):
  line=input()
  if len(line) != 0:
    l=line.split()
    for i in range(1, len(l)):
      s[int(l[i])-1]=1
  else: break

for i in range(m):
  r &= s[i]
  
if(r):
  print("YES")
else:
  print("NO")