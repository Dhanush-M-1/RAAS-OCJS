a,b=map(int,input().split())
c=str(a)
n=0
t=a
for nn in range(500):
    t=a//b
    tt=a%b
   
    if t==0:
        break
    else:
        n=n+t
        a=t+tt
        
        
print(int(c)+n)        