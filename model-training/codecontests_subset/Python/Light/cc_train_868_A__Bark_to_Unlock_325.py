s=input()
n=int(input())

l=[]
for i in range(n):
   l.append(input())

if s in l:
   print("YES")
   exit(0)

l2=[]

for i in range(n):
   for j in range(n):
      l2.append(l[i][1]+l[j][0])

if s in l2:
   print("YES")
else:
   print("NO")