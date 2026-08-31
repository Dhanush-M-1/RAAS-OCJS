x=input()
n=int(input())
list=[]
b=0
for i in range (n):
  a=input()
  list.append(a)
for i in range (n):
  for j in range (n):
    if (x in (list[i]+list[j])):
      print ("YES")
      b=1
      break
  if (b==1):
    break
if (b==0):
  print ("NO")