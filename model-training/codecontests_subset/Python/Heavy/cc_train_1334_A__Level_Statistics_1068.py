def is_possible(n):

    jogadas = 0
    clears = 0

    ver = False

    for i in range(n):
        lista = [int(valor) for valor in input().split()]
        aux_jogadas = lista[0]
        aux_clears = lista[1]

        if(aux_jogadas < jogadas):
            ver = True

        if(aux_clears < clears):
            ver = True

        variacao_jogadas = aux_jogadas - jogadas
        variacao_clears = aux_clears - clears

        if(variacao_clears > variacao_jogadas):
            ver = True

        jogadas = lista[0]
        clears = lista[1]

    if(ver):
        return "NO"
    else:
        return "YES"

entrada = int(input())

for i in range(entrada):
    n = int(input())
    print(is_possible(n))