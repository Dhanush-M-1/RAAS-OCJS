n=int(input(""))
dizi=list(input(""))
 
sekiz=0
for j in range(n):
    if(dizi[j]=="8"):
        sekiz=sekiz+1

sayi=int(len(dizi)/11 )
if(sekiz==0):
    print(0)
else:
    if(sekiz>sayi):
        print(int(sayi))
    else:
        print(int(sekiz))