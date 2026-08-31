def permuta(array,custo,mapa):
    if len(array) == 0 :
        return

    max_indice = -1
    max_valor = -1

    for indice,valor in enumerate(array) :

        if (int(valor) > max_valor):
            max_indice = indice
            max_valor = int(valor)

    mapa[max_valor] = custo
    permuta(array[:max_indice],custo+1,mapa)
    
    if (max_indice!= len(array)-1):
        permuta(array[max_indice+1:],custo+1,mapa)

def resolve_arvore(array):
    mapa ={}
    permuta(array,0,mapa)
    for i in array :
        print(mapa[int(i)])
    print("",end="\n")

entrada = int(input())

for i in range(entrada):
    valor = input()
    array = input().rstrip().split()
    resolve_arvore(array)