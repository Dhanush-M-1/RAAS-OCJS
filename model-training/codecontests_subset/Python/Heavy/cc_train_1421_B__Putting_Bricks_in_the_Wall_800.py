for _ in range(int(input())):
    n = int(input())
    siatka = [[] for _ in range(n)]
    for x in range(n):
        siatka[x] = input()
    wynik = []
    if siatka[0][1] == siatka[1][0]:
        if siatka[-1][-2] == siatka[0][1]:
            wynik += [(n, n-1)]
        if siatka[-2][-1] == siatka[0][1]:
            wynik += [(n-1, n)]
    elif siatka[-1][-2] == siatka[-2][-1]:
        if siatka[-1][-2] == siatka[0][1]:
            wynik += [(1, 2)]
        if siatka[-2][-1] == siatka[1][0]:
            wynik += [(2, 1)]
    else:
        wynik += [(1, 2)]
        if siatka[-1][-2] == siatka[1][0]:
            wynik += [(n, n-1)]
        else:
            wynik += [(n - 1, n)]
    print(len(wynik))
    for x in wynik:
        print(x[0], x[1])