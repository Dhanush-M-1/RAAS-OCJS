#!/usr/bin/python3
n=int(input())
if n <= 2:
  print(n)
  exit()
px,ph=map(int,input().split())
x,h=map(int,input().split())
res=1
ch=0
for i in range(1,n-1):
  nx,nh=map(int,input().split())
  if ch+h < x-px:#left
    res+=1
    ch=0
  elif h < nx-x:#right
    res+=1
    ch=h
  else:
    ch=0
  px,ph=x,h
  x,h=nx,nh
res+=1  
print(res)  
    
    
