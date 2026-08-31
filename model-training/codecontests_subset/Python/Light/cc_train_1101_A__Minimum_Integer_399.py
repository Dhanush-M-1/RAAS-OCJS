import math
n=int(input())
for i in range(0,n):
    x,y,z=map(int,input().split())
  #  print(x,y,z)
    #print(x/z)
    if z<x:
         print(z)
    else:
         if y%z==0:
              print(y+z)
         else:
              print((y//z)*z+z)
   
     
       
