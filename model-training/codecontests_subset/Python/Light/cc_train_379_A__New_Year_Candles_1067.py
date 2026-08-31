row = str(input()).split(' ')
n=int(row[0])
r=int(row[1])
aux=0

usadas=n
recicladas=n/r
while(recicladas>1):
    usadas+=int(recicladas)
    aux=float(str(recicladas-int(recicladas))[1:])
    recicladas=int(recicladas)/r
    recicladas+=aux

if(recicladas==1.0):
    usadas+=1


print (usadas)

