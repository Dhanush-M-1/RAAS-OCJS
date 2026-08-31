kata = input()

if(len(kata)==1):
    print(kata)
else:
    angkas = []
    simbols = []

    foundAngka = ""
    for i in range(len(kata)):
        iAlpha = ord(kata[i])

        if(iAlpha < 48 or iAlpha > 57):
            angkas += [int(foundAngka)]
            foundAngka = ""
            simbols += [kata[i]]
            continue

        foundAngka += kata[i]
        
    angkas += [int(foundAngka)]


    for i in range(1, len(angkas)):
        temp = angkas[i]
        j = i-1
        while(j>=0 and temp<angkas[j]):
            angkas[j+1] = angkas[j]
            j = j - 1

        angkas[j+1] = temp

    for i in range(len(simbols)):
        print(str(angkas[i]) + simbols[i],end="")

    print(angkas[len(angkas)-1])
