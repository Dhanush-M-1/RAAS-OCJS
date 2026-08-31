n = int(input())
lista = str(input()).split()
impar = []
par = []
flag = False
flag2 = False
tamanho = 0
tamanho2 = 0
for num in lista:
    if int(num)%2 == 1:
        impar.append(int(num))
    else:
        par.append(int(num))

tamanho = len(impar)
tamanho2 = len(par)
impar.sort()
par.sort()

if (tamanho > tamanho2 or tamanho == tamanho2) and (tamanho != 0 or tamanho2 != 0):
    while(tamanho != 0 or tamanho2 != 0) and flag == False and flag2 == False:
        if tamanho != 0:
            del impar[-1]
            tamanho = tamanho - 1
        else:
            flag = True

        if tamanho2 != 0:
            del par[-1]
            tamanho2 = tamanho2 - 1
        else:
            flag2 = True

elif(tamanho2 > tamanho and (tamanho != 0 or tamanho2 != 0)):
    while(tamanho != 0 or tamanho2 != 0) and flag == False and flag2 == False:
        if tamanho2 != 0:
            del par[-1]
            tamanho2 = tamanho2 - 1
        else:
            flag2 = True

        if tamanho != 0:
            del impar[-1]
            tamanho = tamanho - 1
        else:
            flag = True




if tamanho == 0 and tamanho2 == 0:
    print("0")
elif tamanho == 0 and tamanho2 != 0:
    print(sum(par))
elif tamanho != 0 and tamanho2 == 0:
    print(sum(impar))
