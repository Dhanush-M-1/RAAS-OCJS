n,x,y=map(int,input().split())
c1=n*y/100
c2=n*y//100
if c1==c2 :
    c2=int(c1)
else:
    c2=int(c1)+1
if c2-x>=0:
     print(c2-x)
else:
     print(0)
