n=int(input())
x=[]
h=[]
for i in range(n):
    ch=input()
    L=[int(i)for i in ch.split()]
    x.append(L[0])
    h.append(L[1])
nx=len(x)

xd=x
nb=2
for i in range(1,nx-1):
    if x[i]-h[i]>xd[i-1]:
        nb+=1
    elif x[i]+h[i]<xd[i+1]:
        nb+=1
        xd[i]+=h[i]
if n==1:
    print(1)
else:
    print(nb)
    




    
