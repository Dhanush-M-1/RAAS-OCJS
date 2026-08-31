password = str(input())
num = int(input())
lista = []

for i in range(num):
    lista.append(list(input().split()))

for j in lista:
    if j[0][1] == password[0]:
        for k in lista:
            if k[0][0] == password[1]:
                print("YES")
                quit()

    if j[0] == password:
        print("YES")
        quit()


else:
    print("NO")