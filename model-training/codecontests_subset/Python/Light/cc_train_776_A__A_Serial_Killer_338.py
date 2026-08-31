nome1, nome2 = input().split()
print(nome1, nome2)
for i in range(int(input())):
    assassinado, substituto = input().split()
    if assassinado == nome1:
        nome1 = substituto
    else:
        nome2 = substituto
    print(nome1, nome2)