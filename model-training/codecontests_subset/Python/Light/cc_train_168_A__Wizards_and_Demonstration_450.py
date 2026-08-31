n,x,y=map(int,input().split())
b=((n*y)/100)
m=((n*y)%100)
if b > x :
  if m:
   print((int(b)+1)-x) 
  else:
    print(int(b)-x)
else :
  print(0)