x = input().split()
myList = []
for y  in range(int(x[0])):
  k = input().split()
  f=0
  for y in range(int(k[f])):
    f+=1
    if(len(myList)==0):
      myList.append(int(k[f]))
    else:
      z=0
      for y in range(len(myList)):
        if(myList[y]==int(k[f])):
          z=1
      if(z==0):
        myList.append(int(k[f]))
if(len(myList)==int(x[1])):
  print("YES")
else:
  print("NO")