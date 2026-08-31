from math import *
t=int(input())
while(t):
 t-=1
 n=int(input())
 a=list(map(int,input().split()))
 k=0
 re=[]
 flag=0
 d=0
 d2=-11111111
 for i in range(n-1):
  #print(k,d)
  if(flag==0 and ((a[i+1]==-1 and a[i]!=-1) or (a[i]==-1 and a[i+1]!=-1))):
   k=max(a[i],a[i+1])
   d=0
   flag=1
   continue
  if(a[i]==a[i+1]==-1):
   continue
  if(a[i]==-1 and a[i+1]!=-1):
   new=abs(k-a[i+1])
   if(new>d):
    d1=ceil((-d+new)/2)
    d+=d1
    if(a[i+1]>k):
     k+=d1
    else:
     k-=d1
  elif(a[i]!=-1 and a[i+1]==-1):
   new=abs(k-a[i])
   if(new>d):
    d1=ceil((-d+new)/2)
    d+=d1
    if(a[i]>k):
     k+=d1
    else:
     k-=d1
  else:
   re.append(abs(a[i]-a[i+1]))
   if(re[-1]>d):
    d2=re[-1]
 re.append(d2)
 for i in range(n):
  if(a[i]==-1):
   a[i]=k
 f=0
 for i in range(n-1):
  f=max(f,abs(a[i]-a[i+1]))
 d=max(re+[f])
 print(d,k)
    
   
  
