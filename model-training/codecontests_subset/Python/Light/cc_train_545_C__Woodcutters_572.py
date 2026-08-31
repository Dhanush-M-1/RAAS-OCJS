n=int(input())

x=list()
h=list()

for i in range(n):
    a,b=map(int,input().split())
    x.append(a)
    h.append(b)
    

cn=1
for i in range(1,len(x)-1):
    
    if(x[i]-x[i-1]>h[i]):
        cn+=1
    elif(x[i+1]-x[i]>h[i]):
        cn+=1
        x[i]=x[i]+h[i]
   
if(n!=1):        
    print(cn+1)
else:
    print (cn)