k=input().split()
a=int(k[0])
b=int(k[1])
noc=0
k=0
while a>0:
    noc+=a
    k+=a%b
    #print(k,noc)
    a=a//b
while k>0:
    noc+=k//b
    if k>b:
        k=k%b+k//b
    else:
        k=k//b
    #print(noc,k)
print(noc)






    
    
    
