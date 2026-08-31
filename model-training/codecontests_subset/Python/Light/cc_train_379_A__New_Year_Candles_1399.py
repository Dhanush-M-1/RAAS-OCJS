a,b=map(int,input().split())
c=a
m=a
while(True):
   c=c+m//b
   m=m%b+m//b
   if m<b:
      print(c)
      break
 