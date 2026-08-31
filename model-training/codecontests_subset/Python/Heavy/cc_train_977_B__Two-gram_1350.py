n=int(input())
l=input().upper()
l=list(l)
h=0
k=0
b=0
u=len(l)-1
p=0
for i in range(0,1):
    g=l[i:i+2]
    if g==['U','R']:
       b=2
       break
    else:
         for i in range(u):
             g=l[i:i+2]
             if g==p:
                 v=0
             else:
                 for j in range(i+1,len(l)) :
                     if g==l[j:j+2]:
                         h=h+1
             if h>k:
            
                p=g
                k=h
                h=0
                b=1
if b==1:
    
    print(''.join(map(str,p)))
elif b==2:
    print("IB")
else:
    print(''.join(map(str,g)))
