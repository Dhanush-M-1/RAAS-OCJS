import math
t=int(input())
for i in range(t):
         n=int(input())
         k=n
         f6=0
         f3=0
         f=0
         while(k>1):
                  if(k%6==0):
                           f6+=1
                           k=k/6
                  else:
                           break

         while(k>1):
                  if(k%3==0):
                           f3+=1
                           k=k/3
                  else:
                           f=1
                           break
         if(f==1):
                  print(-1)
         elif(n==1):
                  print(0)
         else:
                  print(f6+(2*f3))
                  
                  
