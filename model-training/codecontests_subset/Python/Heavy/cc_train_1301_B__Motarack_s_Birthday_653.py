from collections import Counter
from collections import defaultdict
import math
t=int(input())
for _ in range(0,t):
    n=int(input())
    a=list(map(int,input().split()))
    diff=0
    q=[]
    f=0
    for i in range(0,n):
        if(a[i]!=-1):
            #print(i)
            if(i==0 and a[i+1]==-1):
                #print("ff")
                q.append(a[i])
            elif(i==n-1 and a[i-1]==-1):
                q.append(a[i])
            elif( i!=0 and i!=n-1 and (a[i-1]==-1 or a[i+1]==-1)):
                q.append(a[i])
    if(len(q)==0):
        r1=0
        for i in range(0,n-1):
            r1=max(r1,abs(a[i]-a[i+1]))
        print(r1,0)
        continue
  #  print(q)
    #print(sum(q),len(q),"llll")
    q.sort()
    s1=(q[0]+q[-1])//2
    s2=math.ceil((q[0]+q[-1])/2)
  #  print(s1,s2,"lllk")
    mx=max(q)
    mn=min(q)
    diff1=0
    w1=[0]*n
    w2=[0]*n
    for i in range(0,n):
        if(a[i]==-1):
            w1[i]=s1
        else:
            w1[i]=a[i]
    for i in range(0,n):
        if(a[i]==-1):
            w2[i]=s2
        else:
            w2[i]=a[i]
    r1=0
    r2=0
   #print(w1,w2)
   # print(q)
    for i in range(0,n-1):
        r1=max(r1,abs(w1[i]-w1[i+1]))
        r2=max(r2,abs(w2[i]-w2[i+1]))
    if(r1<r2):
        print(r1,s1)
    else:
        print(r2,s2)