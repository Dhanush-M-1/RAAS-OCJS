def task():
  p=input().split()
  l=int(p[0])
  u=int(p[1])
  d=int(p[2])
  if(d<l or d>u):
      print(d)
  else:
      print (d*(1+u//d))
    
    
t=int(input())
i=0
while i<t:
 task()
 i+=1